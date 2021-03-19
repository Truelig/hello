package com.ttu.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;

    public void say(){
        System.out.println("i am aAaAa");
    }
}
