package com.tuu.controller;

import com.tuu.res.GrowingResponse;
import com.tuu.to.GrowingColumn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/growing")
public class GrowingIo {

    @PostMapping("/chatdata")
    public GrowingResponse getData(HttpServletRequest httpServletRequest) {
        GrowingResponse growingResponse = new GrowingResponse(999, "ok");
        Map<String, Object> res = new HashMap<>();
        growingResponse.setData(res);
        List<GrowingColumn> columns = new ArrayList<>();
        GrowingColumn column = new GrowingColumn();
        column.setId("tm");
        column.setName("时间");
        columns.add(column);

        Map<String, Object> meta = new HashMap<>();
        meta.put("columns",columns);
        res.put("meta",meta);

        return null;
    }
}
