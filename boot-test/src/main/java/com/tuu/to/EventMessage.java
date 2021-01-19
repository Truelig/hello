package com.tuu.to;

import java.util.Map;

public class EventMessage {
    private static final long serialVersionUID = -5228910337644290100L;
    // 事件发生时间时间戳（毫秒）
    private String time;
    // 事件标识
    private String eventType;
    //平台
    private String source;
//    private

    private Map<String, Object> data;
}
