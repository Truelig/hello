package com.tuu.springboot;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.tuu.springboot.to.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析配置文件YML
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootApplicationTests {

    @Value("${a}")
    String a;
    //el表达式
    @Value("#{${b}+${c}}")
    int sum;

    @Autowired
    Student student;
    //调用静态方法
    @Value("#{T(java.lang.Math).random()}")
    double aDouble;

    @Test
    void test() {
        System.out.println(a);
        System.out.println(sum);
        System.out.println(student);
        System.out.println(aDouble);


    }

}
