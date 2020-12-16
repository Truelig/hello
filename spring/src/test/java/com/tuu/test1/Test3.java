package com.tuu.test1;

public class Test3 {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            User user = new User();
            user.setAge(111);
            user.setId(444);
            user.setName("zhaoFang");
            i++;
        }
        while (true) {

        }
    }
}

class User {
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