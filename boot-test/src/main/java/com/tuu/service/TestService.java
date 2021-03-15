package com.tuu.service;

import io.growing.sdk.java.GrowingAPI;
import io.growing.sdk.java.dto.GIOEventMessage;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public static void main(String[] args) {


        //事件行为消息体
        GIOEventMessage eventMessage = new GIOEventMessage.Builder()
                .eventTime(System.currentTimeMillis())            // 事件时间，默认为系统时间（选填）
                .eventKey("BuyProduct")                           // 事件标识 (必填)
                .loginUserId("18682036560")                   // 登录用户ID (必填)
                .addEventVariable("product_name", "苹果")          // 事件级变量 (选填)
                .addEventVariable("product_classify", "水果")      // 事件级变量 (选填)
                .addEventVariable("product_price", 14)            // 事件级变量 (选填)
                .build();
            //上传事件行为消息到服务器
        GrowingAPI.send(eventMessage);
    }

}
