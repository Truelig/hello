package com.tuu.phone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProxyAddressUtil {

    private static final Logger log = LoggerFactory.getLogger(ProxyAddressUtil.class);

    /**
     * 获取代理地址信息
     *
     * @param provinceEnum       省份
     * @param proxyAddressNumber 代理地址数据
     * @return
     */
    public static List<JSONObject> getProxyAddress(ProvinceEnum provinceEnum, int proxyAddressNumber) {
        List<JSONObject> result = null;
        String proxyResult = HttpUtils.doPostJson("http://webapi.http.zhimacangku.com/getip?num=" + proxyAddressNumber + "&type=2&pro=0&city=0&yys=0&port=1&time=1&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=" + provinceEnum.getCode(), "");

        log.info("getProxyAddress:::::::proxyResult:::::::" + proxyResult);
        if (!StringUtils.isEmpty(proxyResult)) {
            try {
                result = JSONObject.parseObject(JSON.parseObject(proxyResult).getString("data"), List.class);
            } catch (Exception e) {
                result = JSONObject.parseObject(JSON.parseObject(proxyResult).getString("data"), List.class);
            }

        }

        return result;
    }
}
