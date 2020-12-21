package com.tuu.phone;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.time.LocalDateTime;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {
        List<JSONObject> proxyAddress = ProxyAddressUtil.getProxyAddress(ProvinceEnum.上海市, 1);
        String proxyHost = proxyAddress.get(0).getString("ip");
        Integer proxyPort = proxyAddress.get(0).getInteger("port");
//        System.setProperty("https.proxyHost", proxyHost);
//        System.setProperty("https.proxyPort", proxyPort.toString());
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");


//        HttpResponse rsp = client.execute(post);
        JSONObject params = new JSONObject();
        params.put("data", "81e56802d9e92f6eda62bb8595b259e892808401724a14a7d838f76e460bb3ae8841afc7aa141f49db7f42dec22724e43759b42ef5157299c4b443f9d1e5fe1bce7063098f6b0c405d2dd797714e57158c8a869a9275918a5c82be878c8a583c150edadbca7e3a31ac007211eecfb3783fe0e171bddf1b6e91c115544935537f");
        params.put("key_id", "14");
        params.put("sign", "794c7ec2");
        params.put("page", 1);
        params.put("size", 10);
        params.put("search", "13221323802");
        doPost(proxyHost, proxyPort, params.toJSONString());

//        String res = HttpUtils.post(url, params.toJSONString());
//        System.out.println(res);
//        JSONObject resJson = JSONObject.parseObject(res);
//        if (resJson.get("message") != null && resJson.get("message").toString().contains("频率过快")) {
//
//        }


    }

    private static void getProxyHttp(String proxyHost, Integer proxyPort) {
    }

    private static String doPost(String proxyHost, Integer proxyPort, String reqJson) {
        HttpResponse rsp = null;
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://haoma.baidu.com/api/v1/search";
        HttpPost post = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
                .setProxy(proxy)  //设置代理
                .build();//设置请求和传输超时时间
        post.setConfig(requestConfig);
        StringEntity params = null;
        String rspStr = "";
        params = new StringEntity(reqJson, "utf-8");
        params.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        params.setChunked(true);
        post.addHeader("content-type", "application/json");
        post.setEntity(params);
        String rspString = null;
        JSONObject rspJson = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("开始调用百度号码接口"+localDateTime);
        int count = 0;
        try {
            while (true) {
                count++;
                rsp = client.execute(post);
                HttpEntity entity = rsp.getEntity();
                rspString = EntityUtils.toString(entity, "utf-8");
                rspJson = JSONObject.parseObject(rspString);
                System.out.println("***************"+reqJson.toString());
                if (rspJson.get("message") != null && rspJson.get("message").toString().contains("频率过快")) {
                    System.out.println("调用"+count+"次后，频率限制");
                    LocalDateTime localDateTime1 = LocalDateTime.now();
                    System.out.println("结束时间："+localDateTime1+"休息6秒");
                    Thread.sleep(6*1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rspStr);
        return rspStr;

    }
}
