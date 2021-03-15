package com.tuu.proxy;

import com.tuu.phone.HttpUtils;
import okhttp3.OkHttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyManager<T> {
    private String url;
    private Class<T> clazz;
    private OkHttpClient okHttpClient;


    public ProxyManager(String url, Class<T> clazz,OkHttpClient okHttpClient) {
        this.url = url;
        this.clazz = clazz;
        this.okHttpClient = okHttpClient;
    }

    public T getInstance(){
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{clazz},new ProxyInvocation());
    }

    private class ProxyInvocation implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            String urlStr = url +"/"+method.getName();
            Map<String, String> params = new HashMap<>();
            params.put("msg",args[0].toString());
            String res = HttpUtils.doPosts(urlStr, params);
            return res;
        }
    }
}
