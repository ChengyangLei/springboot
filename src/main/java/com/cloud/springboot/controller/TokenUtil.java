package com.cloud.springboot.controller;

import com.cloud.springboot.util.redis.RedisUtil;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static com.cloud.springboot.util.constant.Constant.MODULE;
import static com.cloud.springboot.util.constant.Constant.REDIS_PREFIX;

/**
 * @Description: TokenUtil
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/20 0020
 * @Version 1.0
 */
public class TokenUtil {


    @Autowired
    private static RedisUtil redisUtil;

    @Autowired
    private static RestTemplate restTemplate;

    static String appid = "wx740ffb5dfc39d2cb";
    static String secret = "6fab0049bc357feefc2c183a8c185dff";
    static String  url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;


    public static Object getToken() {
        String responseObject = restTemplate.getForObject(url, String.class);
        JSONObject tokenObject = JSONObject.fromObject(responseObject);
        Date date = new Date();
        if (!StringUtils.isEmpty(tokenObject)) {
            Object expires_in = tokenObject.get("expires_in");
            long realExpiresTime = new Date(date.getTime() + Long.valueOf(expires_in.toString())).getTime();
            tokenObject.put("realExpiresTime",realExpiresTime);
            redisUtil.set(REDIS_PREFIX + MODULE, tokenObject);
        }
        if (redisUtil.hasKey(REDIS_PREFIX + MODULE)) {
            return redisUtil.get(REDIS_PREFIX + MODULE);
        }
        return "";
    }
}
