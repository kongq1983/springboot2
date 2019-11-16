package com.kq.springmvc.controller;

import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import com.kq.springmvc.httpclient.EmployeeRestfulClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @Autowired
    private EmployeeRestfulClient employeeRestfulClient;

    @Value("${server.port}")
    public String port;

    @RequestMapping("/helloworld")
    public Map<String,String> index() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();
        map.put("name","king1");
        map.put("port",port);

        try{
            Thread.sleep(1000l);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return map;

    }


    @RequestMapping("/employee/add")
    public DtoResult employeeAdd(@RequestBody  Employee e){

        log.info("添加员工接收参数 :{}", e);

        DtoResult result = new DtoResult();
        result.setCode("18800000");
        result.setResult(true);

        return result;

    }

    @RequestMapping("/employee/add1")
    public DtoResult employeeAdd1(){


        DtoResult result = new DtoResult();
        result.setCode("18800000");
        result.setResult(true);

        Employee e = new Employee();
        e.setId(1l);
        e.setAge(18);
        e.setName("king");
        e.setNumber("000001");

        employeeRestfulClient.employeeAdd(e);

        return result;

    }




}
