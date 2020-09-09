package com.tuu.test;

import com.AppConfig;
import com.tuu.importselect.MyImportSelect;
import com.tuu.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ac.getBean(MyImportSelect.class));
    }
}
