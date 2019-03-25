package com.cloud.springboot.util.security;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description: KaptchaConfig
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha(){

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border","no");
        properties.setProperty("kaptcha.textproducer.font.color","black");
        properties.setProperty("kaptcha.textproducer.char.space","5");
        Config config = new Config(properties);

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}