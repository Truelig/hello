package com.tuu.springboot.abc;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (atomicInteger.get() % 3 == 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("aaa");
                        atomicInteger.getAndIncrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            while (true) {
                if (atomicInteger.get() % 3 == 1) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("bbb");
                        atomicInteger.getAndIncrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BBB").start();

        new Thread(() -> {
            while (true) {
                if (atomicInteger.get() % 3 == 2) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("ccc");
                        atomicInteger.getAndIncrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "CCC").start();

        while (true) {

        }

    }

}


