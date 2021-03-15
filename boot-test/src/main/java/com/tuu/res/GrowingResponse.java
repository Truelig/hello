package com.tuu.res;

import java.util.Map;

public class GrowingResponse {

    private int code;
    private String message;
    private Map<String,Object> data;

    public GrowingResponse() {
    }

    public GrowingResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
