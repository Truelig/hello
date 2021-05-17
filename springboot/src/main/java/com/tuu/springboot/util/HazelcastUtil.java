package com.tuu.springboot.util;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


public class HazelcastUtil {

    public static HazelcastInstance hazelcastInstance = null;

    public  static HazelcastInstance getInstance() {
        if (null == hazelcastInstance) {
            Config config = new Config();
            config.setInstanceName("tuu-springboot");
            config.setClusterName("tuu");

            hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        }
        return hazelcastInstance;
    }



}
