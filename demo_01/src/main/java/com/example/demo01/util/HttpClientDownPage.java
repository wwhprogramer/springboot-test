package com.example.demo01.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpClientDownPage {
    // 设置代理，模仿浏览器
    private static final String USER_AGENT
            = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36";

    public static String sendGet(String url) {
        // 1.生成httpClicent, 类似于打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 设置请求和传输超时时间 - 略
        CloseableHttpResponse response = null;
        String html = null;
        // 2.创建get请求
        HttpGet request = new HttpGet(url);
        try {
            request.setHeader("User-Agent", USER_AGENT);
            // 3.执行get请求
            response = httpClient.execute(request);
            // 4.判断相应状态为200，进行处理
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 5.获取相应内容
                HttpEntity httpEntity = response.getEntity();
                html = EntityUtils.toString(httpEntity, "utf-8");
            }else {
                System.out.println("返回的状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (Exception e) {
//            e.printStackTrace();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", e.toString());
            map.put("success", false);
            html = JSON.toJSONString(map);
        } finally {
            // 6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return html;
    }
}
