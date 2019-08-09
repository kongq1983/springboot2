package com.kq.springmvc.httpclient;

import com.alibaba.fastjson.JSON;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * EmployeeRestfulClient
 *
 * @author kq
 * @date 2019-08-09
 */
@Slf4j
@Component
public class EmployeeRestfulClient {

    @Autowired
    private RestTemplate restTemplate;


    private String ADD_URL = "http://127.0.0.1:10000/employee/add";


    public void employeeAdd(Employee e){

        HttpHeaders headers = new HttpHeaders();
        // headers.add("XK-Autho1.0.0", "token "+token);
        headers.add("XK-Autho1.0.0", "token 123456");
        headers.add("Service-Name", "m115");
        headers.add("Content-Type", "application/json;charset=UTF-8");

        String json = JSON.toJSONString(e);

        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        log.info("开始调用添加用户接口 ==========");

        ResponseEntity<String> rss = restTemplate.exchange(ADD_URL, HttpMethod.POST, entity, String.class);

        log.info("添加用户接口返回数据:{}",rss.getBody());

    }


}
