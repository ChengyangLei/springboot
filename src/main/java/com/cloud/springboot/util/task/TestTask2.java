package com.cloud.springboot.util.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TestTask2
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2018/11/8 0008
 * @Version 1.0
 */
@Component
public class TestTask2 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("[" + Thread.currentThread().getName() + "]" + "现在时间：" + dateFormat.format(new Date()));
//    }
}
