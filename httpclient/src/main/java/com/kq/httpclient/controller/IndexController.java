package com.kq.httpclient.controller;


import com.kq.httpclient.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @Autowired
    private com.kq.httpclient.mapper.AccountMapper accountMapper;


    @RequestMapping("/helloworld")
    public Map<String,String> index() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();
        map.put("name","king1");

        return map;

    }


    @RequestMapping("/helloworldDataBase")
    public Map<String, Object> helloworldDataBase() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,Object> map = new HashMap<>();

        try {
            map.put("code", "12000000");
            map.put("accounts", accountMapper.getAccountList());
        }catch (Exception e){
            map.put("code", "12000001");
            log.error("查詢出錯",e);
        }

        return map;

    }



}
