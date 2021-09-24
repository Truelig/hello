package com.tuu.springboot.abc;

import java.time.temporal.ValueRange;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndCondition {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (count % 3 != 0) {
                        conditionA.await();
                    }
                    count++;
                    conditionB.signal();
                    System.out.print("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                if(count%3!=1){
//                    conditionB.await();
                }
                System.out.print("b");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.print("c");
        }).start();

        while (true) {

        }
    }
}
