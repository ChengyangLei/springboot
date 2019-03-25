package com.cloud.springboot.controller;

import com.cloud.springboot.util.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static com.cloud.springboot.util.constant.Constant.MODULE;
import static com.cloud.springboot.util.constant.Constant.REDIS_PREFIX;

/**
 * @Description: TSysMenuController
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/20 0020
 * @Version 1.0
 */

@Api(value = "/tSysMenuController", tags = "菜单接口")
@RestController
@RequestMapping("/tSysMenuController")
public class TSysMenuController {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RestTemplate restTemplate;


    String create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";

    String get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";


    @ApiOperation(value = "保存菜单接口", notes = "保存菜单接口")
    @PostMapping("/saveSysMenu")
    public String saveSysMenu(String menuStr) {
        //从redis 中取出token
        Object tokenObject = redisUtil.get(REDIS_PREFIX + MODULE);
        JSONObject jsonObject = JSONObject.fromObject(tokenObject);
        long realExpiresTime = Long.valueOf(jsonObject.get("realExpiresTime").toString());
        long currentDate = new Date().getTime();
        String token="";

        //判断token是否过期
        if (realExpiresTime < currentDate) {
            token = jsonObject.get("access_token").toString();

        } else {
            Object tokenObject2 = TokenUtil.getToken();
            JSONObject token2 = JSONObject.fromObject(tokenObject2);
            token = token2.get("access_token").toString();
        }
        String result = restTemplate.postForObject(create_url+token, menuStr, String.class);
        return result;
    }

    @ApiOperation(value="查询菜单", notes = "查询菜单")
    @GetMapping("/getSysMenu")
    public String getSysMenu(String token){
        String result = restTemplate.getForObject(get_url+token, String.class);
        return result;
    }


}
