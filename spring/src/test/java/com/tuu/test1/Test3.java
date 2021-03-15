package com.tuu.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    private static final ExecutorService exec = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        map.put("key", 7L);
        for (Map.Entry<String, Long> m : map.entrySet()) {
            System.out.println(m.getKey());
        }
        System.out.println(map.get("key"));
    }

    private static void gey(List<User> l) {
        l.forEach(u -> System.out.println(u.getName()));
    }
}

abstract class User {
    int id;
    int age;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class User1 extends User {

}

class User2 extends User {

}