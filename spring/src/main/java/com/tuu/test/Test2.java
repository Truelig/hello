package com.tuu.test;


import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Test2 {
    public static void main(String[] args) {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("------onSubscribe------");
                this.subscription.request(3);
            }

            @Override
            public void onNext(String item) {
                System.out.println("------onNext------");
                System.out.println("接受到的数据："+item);
//                int n = 0;
//                Scanner sc = new Scanner(System.in);
//                System.out.println("请输入要获取数据量");
//                n = sc.nextInt();
//                subscription.request(2);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        publisher.subscribe(subscriber);
        for (int i = 0; i < 100; i++) {
            System.out.println("生成数据："+i);
            publisher.submit("发送数据"+i);
        }
        System.out.println(publisher.getMaxBufferCapacity());
        System.out.println(publisher.getNumberOfSubscribers());
        while(true){

        }
    }
}
