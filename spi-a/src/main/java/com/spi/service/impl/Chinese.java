package com.spi.service.impl;

import com.spi.service.People;

public class Chinese implements People {

    @Override
    public void say() {
        System.out.println("chinese say nihao");
    }
}
