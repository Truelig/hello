package com.tuu.springboot.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class TestJedis {

    public static void main(String[] args) {
        Set<String> sentinels=new HashSet<>();
        sentinels.add("192.168.11.217:26379");
        sentinels.add("192.168.11.218:26379");
        sentinels.add("192.168.11.219:26379");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels,"123456");
        Jedis resource = jedisSentinelPool.getResource();
        System.out.println(resource.get("a"));
        resource.set("helei","sb");
    }
}


