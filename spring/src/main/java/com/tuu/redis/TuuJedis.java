package com.tuu.redis;

public class TuuJedis {

    public static void main(String[] args) {
//        System.out.println(set("key1", "199"));
//        System.out.println(new TuuSender().insc("key1"));
        System.out.println(new TuuNioSender().set("test1-test2-test3","3"));
        System.out.println(new TuuNioSender().insc("key2"));
    }

    public static String set(String k,String v){
        String res = new TuuSender().set(k, v);
        System.out.println(res);
        return res;
    }

}
