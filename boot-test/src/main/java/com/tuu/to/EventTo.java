package com.tuu.to;

import lombok.Data;

import java.util.List;

/**
 * 埋点事件
 */
@Data
public class EventTo {
    private Long id;
    private Long accountID;
    private String name;
    private String desc;
    private String identityCode;
    private String favorite;
    private List<Label> label;
    private String createPer;
    private long createTime;
    private String modifyPer;
    private long modifyTime;
    private String status;
    private List<AssociateEvent> associateEvent;
}
