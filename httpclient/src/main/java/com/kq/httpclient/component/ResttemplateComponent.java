package com.kq.httpclient.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResttemplateComponent {

    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:10001/helloworld";

    public void start(){




        Runnable r = () -> {
            String result = restTemplate.postForObject(url,null,String.class);
            System.out.println(Thread.currentThread().getName()+"result="+result);
        };

        for(int i=0;i<2000;i++) {
            new Thread(r,i+"").start();
        }

    }


}
