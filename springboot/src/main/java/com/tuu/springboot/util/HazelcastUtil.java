package com.tuu.springboot.util;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.ArrayList;
import java.util.List;

public class HazelcastUtil {

    public static HazelcastInstance hazelcastInstance = null;

    public  static HazelcastInstance getInstance() {
        if (null == hazelcastInstance) {

             hazelcastInstance = Hazelcast.newHazelcastInstance(new Config().setInstanceName("tuu"));
        }
        return hazelcastInstance;
    }



}
