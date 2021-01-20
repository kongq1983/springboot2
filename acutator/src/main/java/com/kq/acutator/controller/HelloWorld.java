package com.kq.acutator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * @date 2021-01-15 14:00
 * @since 2020-0630
 */
@Slf4j
@RestController
public class HelloWorld {

    @RequestMapping("/helloworld")
    public Map<String,String> index() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();
        map.put("name","king1");
//        map.put("port",port);
//        map.put("saleTypeOne",saleTypeOne);
//        map.put("saleTypeTwo",saleTypeTwo);
//        map.put("testUsername",testUsername);
//        map.put("testPassword",testPassword);

        return map;

    }


}
