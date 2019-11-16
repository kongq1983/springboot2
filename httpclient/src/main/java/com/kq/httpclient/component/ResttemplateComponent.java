package com.kq.httpclient.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

@Component
public class ResttemplateComponent {

    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:10001/helloworld";

    public static final int size = 200;

    private static CountDownLatch countDownLatch = new CountDownLatch(size);

    public void start(){

        Runnable r = () -> {
            try {
                String result = restTemplate.postForObject(url, null, String.class);
                System.out.println(Thread.currentThread().getName() + "result=" + result);
            }finally {
                countDownLatch.countDown();
            }
        };

        for(int i=0;i<size;i++) {
            new Thread(r,i+"").start();
        }

        try{
            countDownLatch.await();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("========================end============================");

    }


}
