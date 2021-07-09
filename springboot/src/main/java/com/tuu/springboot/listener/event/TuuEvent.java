package com.tuu.springboot.listener.event;

import org.springframework.context.ApplicationEvent;

public class TuuEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TuuEvent(Object source) {
        super(source);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
