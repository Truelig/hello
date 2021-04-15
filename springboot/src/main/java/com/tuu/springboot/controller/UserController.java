package com.tuu.springboot.controller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.tuu.springboot.util.HazelcastUtil;
import com.tuu.springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    private static Random random = new Random(10);
    @Autowired
    SpringContextUtil springContextUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String lock = "tuu";
    private IMap<String, String> lock_test = HazelcastUtil.getInstance().getMap("lock");

    @GetMapping("/getuser/{id}")
    public String getUserById(@PathVariable("id") String id) {
        System.out.println(666);
        // System.out.println(springContextUtil.getBean(AppConfig.class));
        String a = "666";
        String b = String.valueOf("666");
        System.out.println(a.equals(b));
        stringRedisTemplate.opsForValue().set(id, id);
        return "jack的id:" + id;
    }


    @GetMapping("/testredes")
    public void test() {
        for (int j = 0; j < 2000; j++) {
            new Thread(() -> {
                int i = 0;
                try {
                    while (true) {
                        i = random.nextInt(3);
                        long st = System.currentTimeMillis();
                        stringRedisTemplate.opsForValue().increment("testIncr");
                        long time = System.currentTimeMillis() - st;
                        String name = Thread.currentThread().getName();
                        if (time > 500) {
                            System.out.println(name + "跟新redis耗时 " + time + " ms ");
                        }
                        Thread.sleep(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @GetMapping("/lock1")
    public void test1() {
        System.out.println("lock1开始上锁");
        synchronized (lock) {
            System.out.println("lock1锁了");
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("lock1解锁");

    }


    @GetMapping("/lock2")
    public void test2() {
        System.out.println("lock2开始上锁");
        synchronized (lock) {
            System.out.println("lock2锁了");
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("lock2解锁");

    }

    @GetMapping("/hazelcast")
    public void test3() throws Exception{
            for (int i = 0; i < 2000; i++) {

                new Thread(()->{

                    while (true) {
                        long st = System.currentTimeMillis();
                        boolean tryLock = false;
                        try {
                            tryLock = lock_test.tryLock("tuu999", 10, TimeUnit.SECONDS, 2, TimeUnit.SECONDS);
                            long time = System.currentTimeMillis() -st;
                            String name = Thread.currentThread().getName();
                            if (time>20) {
                                if (tryLock) {
                                    System.out.println(name+"上锁成功 "+time);
                                } else {
                                    System.out.println(name+"上锁失败 "+time);
                                }
                            }
                            lock_test.unlock("tuu999");
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();

            }


    }


}
