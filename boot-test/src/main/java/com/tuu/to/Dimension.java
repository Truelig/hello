package com.tuu.to;

import lombok.Data;

/**
 * 维度  指标
 */
@Data
public class Dimension {
    private Long id;
    private String accountID;
    private String name;
    private String desc;
    private String remark;
    private String type;//1维度  2指标
}
