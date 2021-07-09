package com.tuu.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.tuu.springboot.util.RestUtils;
import org.apache.dubbo.common.utils.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChartSetController {

    @ResponseBody
    @PostMapping("/rest")
    public void call(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> requestParams = getRequestParams(request);
        String name1 = requestParams.get("name");
//        request.setCharacterEncoding("GBK");
        response.setContentType("application/json");
        String chaset = "UTF-8";
        response.setCharacterEncoding(chaset);
//        String name = new String(name1.getBytes("GBK"),"GBK");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name1);
        OutputStream opt = null;
        OutputStreamWriter out = null;
        opt = response.getOutputStream();
        out = new OutputStreamWriter(opt, chaset);
        out.write(jsonObject.toString());
        out.flush();

    }

    @ResponseBody
    @PostMapping("/rest1")
    public void call1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("result");
        Element elem = root.addElement("sms");
        elem.setText("111");
        elem = elem.addElement("sms_1");
        elem.setText("111_1");
        elem = elem.addElement("sms_2");
        elem.setText("111_2");
        String s = document.asXML();
        System.out.println(s);
    }


    @ResponseBody
    @PostMapping("/rest3")
    public void call3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        JSONObject params = RestUtils.analysisRequest(request);
        String sms = (String) params.get("sms");
        System.out.println(sms.length());

    }

    //form-data
    public static Map<String, String> getRequestParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>(11);
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            if (!StringUtils.isEmpty(value)) {
                params.put(name, value);
            } else {
                params.put(name, "");
            }
        }
        return params;
    }


    /**
     * 解析json格式参数
     *
     * @param request
     */
    public static JSONObject analysisRequest(HttpServletRequest request) throws IOException {

        InputStreamReader isr = new InputStreamReader(request.getInputStream(), "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        return JSONObject.parseObject(IOUtils.read(reader));
    }
}
