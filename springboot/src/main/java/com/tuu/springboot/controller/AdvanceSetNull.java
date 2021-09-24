package com.tuu.springboot.controller;

public class AdvanceSetNull {

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + "  was finalize");
    }

    public static void main(String[] args) {
        AdvanceSetNull advanceSetNull = new AdvanceSetNull();
        System.out.println(advanceSetNull +"  is  created");
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_00 == 0){
                System.gc();
            }
        }
        System.out.println("loop is over");
    }
}
