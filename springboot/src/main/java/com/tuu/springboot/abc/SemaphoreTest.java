package com.tuu.springboot.abc;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量 循环顺序打印abc
 */
public class SemaphoreTest {
    //a先开始
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(()->{

            while (true) {
                try {
                    Thread.sleep(1000);
                    semaphoreA.acquire();
                    System.out.println("AAA");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{

            while (true) {
                try {
                    Thread.sleep(1000);
                    semaphoreB.acquire();
                    System.out.println("BBB");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{

            while (true) {
                try {
                    Thread.sleep(1000);
                    semaphoreC.acquire();
                    System.out.println("CCC");
                    System.out.println("------------------------");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        while(true){

        }
    }
}
