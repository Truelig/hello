package com.tuu.test1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {

    @Test
    public void test(){
         ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("号码信息查询线程池-");
                return thread;
            }
        });
         List<People> list = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            People p = new People();
            p.setAge(i+"");
            list.add(p);
        }

        list.forEach(l->{
            executor.execute(()->{
//                System.out.println(Thread.currentThread().getName());
                l.setName("name1111");
            });
        });
        boolean b = list.stream().allMatch(l -> l.getName() != null);
        Assert.assertTrue(b);

    }
}

class People{
    String age;
    String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}