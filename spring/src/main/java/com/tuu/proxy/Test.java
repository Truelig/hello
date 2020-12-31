package com.tuu.proxy;

import okhttp3.OkHttpClient;

public class Test {
    public static void main(String[] args) {
        String url = "http://localhost:8080/test/user";
        OkHttpClient okHttpClient = new OkHttpClient();
        UserService userService =  new ProxyManager<>(url,UserService.class,okHttpClient).getInstance();
        System.out.println(userService.test1("wuqing66666"));
    }
}
