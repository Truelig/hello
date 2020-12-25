package com.tuu.test1.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class Test1 {


    //哪个返回的快，用哪个的结果 acceptEither 无返回值
    @Test
    public void test1(){
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }),r-> System.out.println(r)).join();
    }

    //哪个返回的快，用哪个的结果 applyToEither有返回值
    @Test
    public void test2(){
      String ss=  CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }),r-> {
            System.out.println(r+"99999");
            return r;
        }).join();

        System.out.println(ss);
    }

    //哪个返回的快，用哪个的结果 applyToEither有返回值
    @Test
    public void test3(){
        String ss=  CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }),r-> {
            System.out.println(r+"99999");
            return r;
        }).join();

        System.out.println(ss);
    }

}
