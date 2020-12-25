package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(99999);
    }
}
