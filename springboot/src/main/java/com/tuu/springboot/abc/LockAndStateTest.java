package com.tuu.springboot.abc;

import java.util.concurrent.locks.ReentrantLock;

public class LockAndStateTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static volatile int state = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        Thread.sleep(1000);
                        System.out.print("aaa");
                        state++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        },"AAA").start();

        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        state++;
                        System.out.print("bbb");
                    }
                }  finally {
                    lock.unlock();
                }
            }
        },"BBB").start();

        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        state++;
                        System.out.print("ccc");
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"CCC").start();

        while (true) {

        }

    }
}
