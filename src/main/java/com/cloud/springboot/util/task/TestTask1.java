package com.cloud.springboot.util.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: TestTask1
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2018/11/8 0008
 * @Version 1.0
 */
@Component
public class TestTask1 {

    private int count=0;

    /**
     * @Scheduled所支持的参数：
     * 1. cron：cron表达式，指定任务在特定时间执行；
     * 2. fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
     * 3. fixedDelayString：与fixedDelay含义一样，只是参数类型变为String；
     * 4. fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
     * 5. fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String；
     * 6. initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
     * 7. initialDelayString：与initialDelay的含义一样，只是将参数类型变为String；
     * 8. zone：时区，默认为当前时区，一般没有用到。
     */
//    @Scheduled(cron="*/6 * * * * ?")
//    private void process(){
//        System.out.println("[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++));
//    }

}
