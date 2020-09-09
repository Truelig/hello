package com.tuu.springboot;

import com.tuu.springboot.to.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootApplicationTests {

    @Value("${a}")
    String a;
    @Value("#{${b}+${c}}")
    int sum;
    @Autowired
    Student student;

    @Test
    void test() {
        System.out.println(a);
        System.out.println(sum);
        System.out.println(student);
    }

}
