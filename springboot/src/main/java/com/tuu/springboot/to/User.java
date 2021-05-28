package com.tuu.springboot.to;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
