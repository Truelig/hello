package com.tuu.springboot.test;

import sun.misc.Unsafe;

public class Test {
    public static void main(String[] args) {
        String s = "s";
        System.out.println(Byte.MAX_VALUE);
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe.hashCode());
    }
}
