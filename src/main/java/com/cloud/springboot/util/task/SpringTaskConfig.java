package com.cloud.springboot.util.task;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


/**
 * SpringTask
 * 优点：
 *
 * 配置非常简单
 * 缺点：
 *
 * 不支持分布式部署
 * 不支持动态配置定时任务
 * 不支持持久化
 * 其实这几个缺点归根结底都是因为不支持持久化，所以如果项目需要持久化定时任务，还是要选择Quartz比较好。
 */
@Configuration
@EnableScheduling
public class SpringTaskConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        //线程池大小
        scheduler.setPoolSize(10);
        //线程名字前缀
        scheduler.setThreadNamePrefix("spring-task-thread");
        return scheduler;
    }


}
