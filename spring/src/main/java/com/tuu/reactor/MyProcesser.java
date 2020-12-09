package com.tuu.reactor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MyProcesser extends SubmissionPublisher<String> implements Flow.Processor<Integer,String> {
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(5);
    }

    @Override
    public void onNext(Integer item) {
        item++;
        System.out.println("process接受的数据"+item);
        if(item>0)
        this.submit(item+"");
        subscription.request(5);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {

    }
}
