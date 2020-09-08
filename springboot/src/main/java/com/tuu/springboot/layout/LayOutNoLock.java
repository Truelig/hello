package com.tuu.springboot.layout;


import org.openjdk.jol.info.ClassLayout;

public class LayOutNoLock {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
