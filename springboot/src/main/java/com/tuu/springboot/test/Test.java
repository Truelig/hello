package com.tuu.springboot.test;


import cn.hutool.core.collection.CollectionUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        long start1 = System.currentTimeMillis();
        for (int i = 1; i < 999999999; i++) {

//            long s = System.currentTimeMillis();
            bitSet.set(i);
//            long time = System.currentTimeMillis() - s;
//            if(time>10){
//                System.out.println("时间是 "+time+" ms indexs是"+i);
//            }
        }
        long time = System.currentTimeMillis() - start1;
        System.out.println("init over " + time);
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            long s = System.currentTimeMillis();
            bitSet.get(i);
            long time2 = System.currentTimeMillis() - s;
            if (time2 > 5) {
                System.out.println("时间是 " + time2+ " ms indexs是" + i);
            }
        }

        System.out.println("888888888888888");


    }

    public   void test3333(String name) throws Exception {
        synchronized (this){
            System.out.println("线程"+name+"进入static synchronized方法");
            Thread.sleep(20*1000);
        }

    }


    public static synchronized void test111(String name) throws Exception {
        System.out.println("线程"+name+"进入static synchronized方法");
        Thread.sleep(20*1000);

    }

    public  synchronized void test222(String name) throws Exception {
        System.out.println("线程"+name+"进入static synchronized方法");
        Thread.sleep(20*1000);

    }

    public static int test() {
        int b = 100;
        try {
//            System.out.println(999);
            b = 111;
//            int a =1/0;
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b = 222;
//            System.out.println(888);
            return b;
        }
    }


}


