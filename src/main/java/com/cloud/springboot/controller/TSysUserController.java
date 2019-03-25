package com.cloud.springboot.controller;


import com.cloud.springboot.entity.TSysUser;
import com.cloud.springboot.service.TSysUserService;
import com.cloud.springboot.util.HttpUtil;
import com.cloud.springboot.util.redis.RedisUtil;
import com.cloud.springboot.util.security.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.*;

import static com.cloud.springboot.util.constant.Constant.MODULE;
import static com.cloud.springboot.util.constant.Constant.REDIS_PREFIX;

@Api(value="/user", tags="用户接口")
@RestController
@RequestMapping("/user")
public class TSysUserController {


    @Autowired
    private TSysUserService tSysUserService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping(value = "/list")
    @PreAuthorize("hasAuthority('/user/list')")
    @ResponseBody
    public List login() {
        List<TSysUser> list =  tSysUserService.getAllUsers();
        return list;
    }

    @RequestMapping(value = "/update")
    @PreAuthorize("hasAuthority('/user/update')")
    @ResponseBody
    public HashMap<String, Object> update() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("state","success");
        return map;
    }


    @RequestMapping(value = "/del")
    @PreAuthorize("hasAuthority('/user/del')")
    @ResponseBody
    public HashMap<String, Object> del() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("state","success");
        return map;
    }
    @RequestMapping(value = "/add")
    @PreAuthorize("hasAuthority('/user/add')")
    @ResponseBody
    public HashMap<String, Object> add() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("state","success");
        return map;
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.logout();
        return "redirect:login";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public TSysUser info() {
        return SecurityUtils.getUser();
    }



    @ApiOperation(value = "获取微信公众号的token",notes = "获取微信公众号的token")
    @GetMapping("/getToken")
    public String getToken(){
        String appid="wx740ffb5dfc39d2cb";
        String secret="6fab0049bc357feefc2c183a8c185dff";
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        String token = restTemplate.getForObject(url, String.class);
        JSONObject tokenObject = JSONObject.fromObject(token);
        Date date = new Date();
        if (!StringUtils.isEmpty(tokenObject)) {
            Object expires_in = tokenObject.get("expires_in");
            long realExpiresTime = new Date(date.getTime() + Long.valueOf(expires_in.toString())).getTime();
            tokenObject.put("realExpiresTime",realExpiresTime);
            redisUtil.set(REDIS_PREFIX+MODULE,tokenObject.toString());
        }
        if (redisUtil.hasKey(REDIS_PREFIX+MODULE)){
            return redisUtil.get(REDIS_PREFIX+MODULE).toString();
        }
        return null;

    }

    /**
     * 获取微信配置，签名等
     *
     * @return
     */
    @ApiOperation(value="获取微信配置，签名等", notes = "获取微信配置，签名等")
    @GetMapping(value = "/getWxConfig")
    @ResponseBody
    public Object getWxConfig() {
        String corpId = "wwc51b851707d268bd";
        String secret="VEv9uOmj574Mdh8sCYwf-8ObAkvAN2DXt-BCCd-L72g";
//        String corpId = ConfigurationInfoUtil.get("info.properties", "weChat.corpId");
//        String secret = ConfigurationInfoUtil.get("info.properties", "weChat.agentSecret");
//        String corpId = ConfigurationInfoUtil.get("info.properties", "weChat_fh.corpId");
//        String secret = ConfigurationInfoUtil.get("info.properties", "weChat_fh.agentSecret");
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken" + "?corpid=" + corpId + "&corpsecret=" + secret;
        String ticketUrl = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=";
//        ticketUrl="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
        String wxUrl="http://127.0.0.1:8586/";
        String currentPageUrl = "";
        if (!StringUtils.isEmpty(wxUrl)) {
            try {
                currentPageUrl =wxUrl+"/";URLDecoder.decode(wxUrl+"/", "UTF-8");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Map<String, String> ret = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        try {
            String result = HttpUtil.urlGet(url, "");
            map.put("accessToken",result);
            JSONObject object = JSONObject.fromObject(result);
            if (object.getInt("errcode") == 0) {
                //获取token
                String token = object.getString("access_token");
                //获取ticket
                String ticketResult = HttpUtil.urlGet(ticketUrl + token, "");
                JSONObject ticketObject = JSONObject.fromObject(ticketResult);

                if (ticketObject.getInt("errcode") == 0) {
                    String ticket = ticketObject.getString("ticket");
                    //生成随机字符串
                    String nonce_str = create_nonce_str();
                    //生成时间戳
                    String timestamp = create_timestamp();
//                    String signature = Sign.getJsSdkSign(ticket, nonce_str, timestamp, currentPageUrl);
                    String content="jsapi_ticket="+ticket+"&noncestr="+nonce_str+"&timestamp="+timestamp+"&url="+currentPageUrl;
                    String signature = getSha1(content);
                    ret.put("nonceStr", nonce_str);
                    ret.put("timestamp", timestamp);
                    ret.put("signature", signature);
                    ret.put("corpId", corpId);
                    ret.put("ticket", ticket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("wxConfig", ret);
        return map;
    }


    public static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 84      * 进行sha1加密
     * 85      * @param str
     * 86      * @return
     * 87
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }


}
