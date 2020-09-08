package com.tuu.springboot.layout;


import org.openjdk.jol.info.ClassLayout;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LayOutWithLock {
    public static void main(String[] args) throws Exception{
        Thread.sleep(5*1000);
        Object object = new Object();
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }
}
