package com.kq.springsession.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/helloworld")
    public Map<String,String> helloworld() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();
        map.put("name","king1");

        return map;

    }


    @RequestMapping("/index")
    public Map<String,String> index(HttpServletRequest request) {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();

        String name = request.getParameter("name");
        map.put("name",name);

        request.getSession().setAttribute("name",name);

        return map;

    }

}
