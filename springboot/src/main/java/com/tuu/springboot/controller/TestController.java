package com.tuu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

//@Controller
//@RequestMapping("/test")
public class TestController {

    private static Integer threadNum = 40;
    private ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
//    private static Queue<Integer> queue = new LinkedBlockingDeque<>();
//    {
//        for (int i = 0; i < 200000000; i++) {
//            queue.add(i);
//        }
//    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

//    @GetMapping("/redis/{id}")
//    public String test(@PathVariable("id") String id) {
//        for (int i = 0; i < threadNum; i++) {
//            while (true) {
//                executorService.submit(() -> {
//                    Integer poll = queue.poll();
//                    long s = System.currentTimeMillis();
//                    Boolean key = stringRedisTemplate.opsForValue().getBit("key", poll);
//                    long e = System.currentTimeMillis() - s;
//                    System.out.println("结果是" + key + "耗时" + e + "ms");
//                });
//            }
//        }
//        return "ok";
//    }
}
