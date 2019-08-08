package com.kq.activemq.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ProducerIndexController
 *
 * @author kq
 * @date 2019-08-06
 */

@RestController
public class ProducerIndexController {

    @RequestMapping("/index")
    @ResponseBody
    String home() {
        return "Hello World!";
    }


    @RequestMapping("/helloworld")
    @ResponseBody
    public Map<String,String> index() {

        Map<String,String> map = new HashMap<>();
        map.put("name","king-18");

        return map;

    }

}
