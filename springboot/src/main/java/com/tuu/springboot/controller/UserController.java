package com.tuu.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/getuser/{id}")
    public String getUserById(@PathVariable("id") String id){
     return "jack的id:"+id;
    }


}
