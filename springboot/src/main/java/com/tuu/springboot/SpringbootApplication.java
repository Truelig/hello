package com.tuu.springboot;

import com.tuu.springboot.listener.event.TuuEvent;
import com.tuu.springboot.to.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//判断容器有没有摸个类，如果有就注入当前类
//@ConditionalOnClass
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("com")
@EnableConfigurationProperties(Student.class)
@EnableScheduling
@EnableAsync
public class SpringbootApplication implements CommandLineRunner , SpringApplicationRunListener {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringbootApplication.class);
//        TuuEvent event = new TuuEvent(new Object());
//        event.setName("tuu20414");
//        applicationContext.publishEvent(event);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
