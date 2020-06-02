package com.kq.resttemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyConpoment1 {

    @Autowired
    private RestTemplate restTemplate;


    public void  execute(){

        ResponseEntity<String> rss = null;
        String url = "http://localhost:10001/timeout/8";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(headers);

        long startTime = System.currentTimeMillis();
        try {

            rss = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        }
        catch (Exception e) {
            long endTime = System.currentTimeMillis();
            System.out.println("MyConpoment1 花费"+(endTime-startTime)/1000);
            e.printStackTrace();
        }

        System.out.println("================================");

    }


}
