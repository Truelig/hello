package com.tuu.springboot.test;


import com.spi.service.People;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<People> load = ServiceLoader.load(People.class);
        Iterator<People> iterator = load.iterator();
        while(iterator.hasNext()){
           iterator.next().say();
        }

    }
}
