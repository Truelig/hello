package com.tuu.springboot.listener;

import com.tuu.springboot.listener.event.TuuEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TuuListener implements ApplicationListener<TuuEvent> {
    @Override
    public void onApplicationEvent(TuuEvent event) {
        System.out.println(Thread.currentThread().getId()+"--------"+event.getName());
    }
}
