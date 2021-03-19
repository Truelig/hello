package com.ttu.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

    @Autowired
    private A a;

    public void say(){
        System.out.println("i am bBbBb");
    }
}
