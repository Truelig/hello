package com.tuu.test1.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import org.junit.Test;

import java.util.Map;
import java.util.Queue;

public class Test11 {
    @Test
    public void test1() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<String, String> map = instance.getMap("test1");
        map.put("k", "贺磊");
        Queue<String> testQueue = instance.getQueue("testQueue");
        testQueue.offer("zhangsan");
    }

    @Test
    public void test2() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<String, String> map = instance.getMap("test1");
        System.out.println(map.get("k"));
    }
}
