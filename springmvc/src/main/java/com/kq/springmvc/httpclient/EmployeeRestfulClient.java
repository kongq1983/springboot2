package com.kq.springmvc.httpclient;

import com.alibaba.fastjson.JSON;
import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    //测试的时候 读取不到
    @Value("${server.port}")
    public String port;
//    public String port="10001";

    @Value("${server.remoteUrl}")
    private String server;



    public void employeeAdd(Employee e){
        String ADD_URL = "http://"+server+":"+port+"/employee/add";

        log.info("开始调用添加用户接口 ========== 路径:{}",ADD_URL);

        HttpHeaders headers = new HttpHeaders();
        // headers.add("XK-Autho1.0.0", "token "+token);
        headers.add("XK-Autho1.0.0", "token 123456");
        headers.add("Service-Name", "m115");
        headers.add("Content-Type", "application/json;charset=UTF-8");

        String json = JSON.toJSONString(e);

        HttpEntity<String> entity = new HttpEntity<String>(json, headers);



        ResponseEntity<String> rss = restTemplate.exchange(ADD_URL, HttpMethod.POST, entity, String.class);

        log.info("添加用户接口返回数据:{}",rss.getBody());

    }


    /**
     * 不是通过json
     * @param e
     */
    public void employeeUpdate(Employee e){

        String UPDATE_URL = "http://"+server+":"+port+"/employee/update/{id}?age={age}";

        // 对PathVariable  RequestParam 都起作用
        DtoResult result = restTemplate.postForObject(UPDATE_URL,e, DtoResult.class,12,20);

        log.info("修改用户接口返回数据:{}",result);

    }


}
