package com.tuu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/test")
public class TestController {

    private  ExecutorService executorService = Executors.newFixedThreadPool(40);
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/redis/{id}")
    public String test(@PathVariable("id") String id){

        int conunt=0;
        while(conunt<100000000){
            conunt++;
            executorService.submit(()->{
                long s = System.currentTimeMillis();
                Boolean key = stringRedisTemplate.opsForValue().getBit("key", 99999999L);
                long e = System.currentTimeMillis()-s;
                if(e>200){

                    System.out.println("结果是"+key+"耗时"+e+"ms");
                }
        });
        }
        return "ok";
    }
}
