package com.tuu.to;

import lombok.Data;

/**
 * 业务标签
 */
@Data
public class Label {
    private Long id;
    private String name;
    private String desc;
    private String createPer;
    private Long createTime;
    private String modifyPer;
    private Long modifyTime;
}
