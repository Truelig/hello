package com.tuu.springboot.job;

import cn.hutool.db.DaoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

//@Component
public class TestJob {

    @Scheduled(fixedRate = 1000)
//    @Async
    public void test() {
        try {
            Thread.sleep(1000 * 5);
            print("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @Scheduled(fixedRate = 10000)
    public void test1() {
        try {
            Thread.sleep(1000 * 20);
            print("test1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(fixedRate = 20000)
    public void test2() {
        try {
            Thread.sleep(1000 * 40);
            print("test2");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void print(String flag) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(Thread.currentThread().getName() + " | " + flag + " | " + zonedDateTime.toLocalDateTime());
    }
}
