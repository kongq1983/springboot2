package com.kq.httpclient.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * netstat -aon | findstr "10001"
 * 会出现一堆wait_time
 */
public class HttpUtils {

    public static final int size = 2000;

    private static CountDownLatch countDownLatch = new CountDownLatch(size);

    private static Set<Integer> set = new HashSet();


    public static String doPost(String url, String data) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000).setConnectTimeout(20000)
                .setConnectionRequestTimeout(10000).build();
        httpPost.setConfig(requestConfig);
        String context = StringUtils.EMPTY;
        if (!StringUtils.isEmpty(data)) {
            StringEntity body = new StringEntity(data, "utf-8");
            httpPost.setEntity(body);
        }
        // 设置回调接口接收的消息头
        httpPost.addHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            context = EntityUtils.toString(entity, HTTP.UTF_8);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                System.out.println(Thread.currentThread().getName()+"关闭response=");
                response.close();

                httpPost.abort();
                httpClient.close();
                System.out.println(Thread.currentThread().getName()+"关闭httpClient=");
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+",返回值="+context);
        set.remove(Integer.valueOf(Thread.currentThread().getName()));
        countDownLatch.countDown();
        return context;
    }


    public static void main(String[] args) throws Exception{
        String url = "http://localhost:10001/helloworld";
//        String result = doPost(url,null);
//        System.out.println("result="+result);

        Runnable r = ()-> doPost(url,null);

        for(int i=0;i<size;i++) {
            set.add(i);
            new Thread(r,""+i).start();
        }


        System.out.println("-----------------开始等待--------------------");
        countDownLatch.await();
        System.out.println("-----------------结束等待--------------------");

//        System.out.println("未处理数量");
    }

}
