package com.tuu.springboot.service.impl;

import com.tuu.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static ExecutorService executorService = new ThreadPoolExecutor(10,
            15 + 1,
            5 * 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Override
    public void test1() {
        executorService.submit(()->{
            try {
                String name = Thread.currentThread().getName();
                logger.info(name+"：开始任务！需要1分钟");
                Thread.sleep(1000*60*1);
                logger.info(name+"：旺柴任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
