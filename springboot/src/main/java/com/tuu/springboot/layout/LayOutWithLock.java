package com.tuu.springboot.layout;


import org.openjdk.jol.info.ClassLayout;

public class LayOutWithLock {
    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }
}
