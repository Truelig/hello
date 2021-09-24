package com.tuu.springboot.controller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.tuu.springboot.service.UserService;
import com.tuu.springboot.test.Test;
import com.tuu.springboot.to.User;
import com.tuu.springboot.util.HazelcastUtil;
import com.tuu.springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    private static Random random = new Random(10);
    @Autowired
    SpringContextUtil springContextUtil;

    @Autowired
    private UserService userServiceImpl;
private static HazelcastInstance hazelcastInstance = HazelcastUtil.getInstance();
private static String name = "xiaoming";


    private String lock = "tuu";
    private IMap<String, String> lock_test = HazelcastUtil.getInstance().getMap("lock");


    @GetMapping("/teststatic")
    public String testa() throws Exception {
        Test.test111(Thread.currentThread().getName());
        return "qqq";
    }
    @GetMapping("/test")
    public String testb() throws Exception {
        Test test = new Test();
        test.test222(Thread.currentThread().getName());
        return "qqq";
    }

    @GetMapping("/getuser/{id}")
    public String getUserById(@PathVariable("id") String id) {
        userServiceImpl.test1();
        return "jack的id:" + id;
    }

    @GetMapping("/set/{money}")
    public String set(@PathVariable("money") String money) {
        IMap<Object, Object> tuu = hazelcastInstance.getMap("tuu");
        User u = new User();
        u.setName(name);
        u.setMoney(Integer.parseInt(money));
        tuu.put(name, u);
        return "ok";
    }
    @GetMapping("/get")
    public String get() {

        IMap<Object, Object> tuu = hazelcastInstance.getMap("tuu");

        for (Map.Entry<Object, Object> e : tuu.entrySet()) {
            try {
                Thread.sleep(10*1000);
                System.out.println(((User)e.getValue()).getMoney());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        return "ok";
    }

}
