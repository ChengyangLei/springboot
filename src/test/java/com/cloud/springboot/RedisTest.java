package com.cloud.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @Description: RedisTest
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/20 0020
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RedisTest {

    private static final Jedis jedis=new Jedis("127.0.0.1",6379);

    @Test
    public void testAdd(){
        jedis.set("redis","jedis");
        System.out.println(jedis.get("redis"));
    }
}
