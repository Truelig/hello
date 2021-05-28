package com.ttu.cycle;

import cn.hutool.core.date.DateTime;
import com.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String s = "\\xe5\\x9b\\x9b\\xe5\\xb7\\x9d,\\xe8\\xbe\\xbe\\xe5\\xb7\\x9e";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        String ss = new String(bytes);
        System.out.println(ss);

    }
}
