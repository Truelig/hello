package com.tuu.phone;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HTTP工具类
 * @author JiangPengFei
 * @version $Id: mayun-new, v 0.1 2018/12/20 14:07 JiangPengFei Exp $$
 */
public class HttpUtils {

//	private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * post请求(用于key-value格式的参数)
     * (此Request 会复用连接数)
     *
     * @param url
     * @param params
     * @return
     */
    public static String doPosts(String url, Map<String, String> params) throws Exception {
        String result = null;
        List<NameValuePair> paramList = new ArrayList<>();
        for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String value = String.valueOf(params.get(name));
            paramList.add(new BasicNameValuePair(name, value));
        }
        result = Request.Post(url).body(new UrlEncodedFormEntity(paramList, "utf-8"))
                .socketTimeout(60000).connectTimeout(30000).execute().returnContent().asString(Charset.forName("utf-8"));
        return result;
    }

	/**
     * post请求，JSON请求
     * (此Request 会复用连接数)
     * @param url
     * @param jsonStr
     * @return
     */
    public static String doPostJson(String url,String jsonStr)
    {
        String result = null;
        try
        {
            System.out.println("doPostJson::::::::::::::::"+url);
            result = Request.Post(url).body(new StringEntity(jsonStr, "utf-8"))
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .socketTimeout(60000).connectTimeout(60000).execute().returnContent().asString(Charset.forName("utf-8"));
        }
        catch (Exception e)
        {

        }
        return result;
    }

	/**
	 * 无参数POST请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url) throws Exception{
		String result = null;
		result = Request.Post(url).addHeader("Content-Type", "application/json;charset=UTF-8")
				.socketTimeout(60000).connectTimeout(60000).execute().returnContent().asString(Charset.forName("utf-8"));
		return result;
	}

    /**
     * post请求
     *
     * @param url
     *            功能和操作
     * @param body
     *            要post的数据
     * @return
     * @throws IOException
     */
    public static String post(String url, String body) {

        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            // 读第一行不加换行符
            boolean firstLine = true;
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }
			out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get请求，JSON请求 无参数，获取 HttpResponse
     * (此Request 会复用连接数)
     * @param url
     * @return
     */
    public static String doGetJson(String url)
    {
        String resultStr = null;
        try
        {
            resultStr = Request.Get(url)
                .socketTimeout(60000).connectTimeout(60000)
                .execute().returnContent()
                .asString(Charset.forName("UTF-8"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         return resultStr;
    }

    public static void main(String[] args) {
        //河北省,130000
        //北京市,110000
        //山西省,140000
        //内蒙古自治区,150000
        //辽宁省,210000
        //吉林省,220000
        //黑龙江省,230000
        //上海市,310000
        //江苏省,320000
        //浙江省,330000
        //安徽省,340000
        //福建省,350000
        //江西省,360000
        //山东省,370000
        //河南省,410000
        //湖北省,420000
        //湖南省,430000
        //广东省,440000
        //重庆市,500000
        //四川省,510000
        //云南省,530000
        //陕西省,610000
        //宁夏回族自治区,640000

        try {
            String resultStr = doPostJson("http://webapi.http.zhimacangku.com/getip?num=125&type=2&pro=0&city=0&yys=0&port=1&time=1&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=310000,440000","");
            //System.out.println(resultStr.indexOf("{\"code\":113,\"data\":[],\"msg\":\"请添加白名单"));
            //System.out.println(resultStr);
            //String resultStr = doGetJson("http://viplego.cn/goods/list?page=1&name=&is_home=1&is_recommend=&is_selected=&is_direct=&limit=50");

            //System.out.println(resultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String doPost(String url, Map<String, String> params) throws Exception {
        String result = null;
        List<NameValuePair> paramList = new ArrayList<>();
        for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String value = String.valueOf(params.get(name));
            paramList.add(new BasicNameValuePair(name, value));
        }
        result = Request.Post(url).body(new UrlEncodedFormEntity(paramList, "utf-8"))
                .socketTimeout(15000).connectTimeout(30000).execute().returnContent().asString(Charset.forName("utf-8"));
        return result;
    }

}
