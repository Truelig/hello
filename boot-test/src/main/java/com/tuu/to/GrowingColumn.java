package com.tuu.to;

import lombok.Data;

@Data
public class GrowingColumn {

    private String id;
    private String name;
    private boolean isDim;
    private boolean isRate;
    private boolean isDuration;

}
