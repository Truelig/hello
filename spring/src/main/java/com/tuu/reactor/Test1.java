package com.tuu.reactor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Test1 {
    public static void main(String[] args) {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        MyProcesser myProcesser = new MyProcesser();
        publisher.subscribe(myProcesser);
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.request(4);
            }

            @Override
            public void onNext(String item) {
                System.out.println("subscriber:"+item);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        myProcesser.subscribe(subscriber);
        publisher.submit(100);
        publisher.submit(-100);

        while (true) ;
    }
}
