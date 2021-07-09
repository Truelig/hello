package com.tuu.test;

import org.springframework.util.StopWatch;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
//        List<String> l = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            l.add(i + "");
//        }
//
//        String temp = null;
//        int count = 0;
//        for (int i = 0; i < l.size() - 2; i++) {
//            for (int j = i + 1; j < l.size(); j++) {
//                for (int z = j + 1; z < l.size(); z++) {
//                    temp = l.get(i) + l.get(j) + l.get(z);
//                    System.out.println(temp);
//                    count++;
//                }
//            }
//        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(10*1000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
