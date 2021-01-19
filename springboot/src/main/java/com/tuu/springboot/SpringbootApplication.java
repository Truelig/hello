package com.tuu.springboot;

import com.tuu.springboot.to.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

//判断容器有没有摸个类，如果有就注入当前类
//@ConditionalOnClass
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("com")
@EnableConfigurationProperties(Student.class)
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
