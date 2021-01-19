package com.tuu.springboot.controller;

import com.tuu.springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    SpringContextUtil springContextUtil;

    @RequestMapping("/getuser/{id}")
    public String getUserById(@PathVariable("id") String id){
        System.out.println(666);
       // System.out.println(springContextUtil.getBean(AppConfig.class));
        return "jack的id:"+id;
    }


}
