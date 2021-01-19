package com.tuu.controller;

import com.tuu.service.UserMapper;
import com.tuu.to.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/test1")
    public String test1(String msg) {
        System.out.println(msg);
        User user = new User();
        user.setName(msg);
        user.setId(2);
        user.insert();
        userMapper.insert(user);
//        User user1 = userMapper.selectById(1);
        return msg;
    }
}
