package com.tuu.springboot.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.common.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/3/11 16:26 JiangPengFei Exp $$
 */
public class RestUtils {

	private final static Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);

	private static final String IP_KEY = "X-Real-IP";

	/**
	 * 组装参数
	 * @param request
	 */
	public static Map<String, String> getRequestParams(HttpServletRequest request) {
		Map<String, String> params = new HashMap<>(11);
		Enumeration<String> names = request.getParameterNames();
		try {
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				String value = request.getParameter(name);
				if(!StringUtils.isEmpty(value)){
					params.put(name, value);
				}else{
					params.put(name, "");
				}
			}
			params.put("client_request_ip_address", getClientIP(request));
		} catch (Exception e) {

		}
		return params;
	}




	/**
	 * 获取客户端IP
	 * 需要在Nginx上配置  才能拿到参数
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String clientIp = request.getHeader(IP_KEY);
		if (clientIp == null) {
			clientIp = request.getRemoteHost();
		}
		return clientIp;
	}


	/**
	 * 解析request参数
	 *
	 * @param request
	 */
	public static JSONObject analysisRequest(HttpServletRequest request) throws Exception {

		InputStreamReader isr = new InputStreamReader(request.getInputStream(), "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		return JSONObject.parseObject(IOUtils.read(reader));
	}


}
