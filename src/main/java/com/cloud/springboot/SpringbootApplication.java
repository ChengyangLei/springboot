package com.cloud.springboot;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.cloud.springboot.dao")
@EnableCaching   //redis
//@EnableCasClient//cas client客户端
public class SpringbootApplication {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //少了配置web.xml、配置springmvc、以及打包部署到tomcat等步骤
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
