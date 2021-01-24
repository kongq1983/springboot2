package com.kq.springmvc.performance;

import com.kq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value="/performance")
public class PerformanceController {

    @RequestMapping("/index")
    public Map<String,String> index() {

        log.info("The test info is :{}", System.currentTimeMillis());
        Map<String,String> map = new HashMap<>();
        map.put("index","index");

        return map;
    }

    @RequestMapping("/requestParams")
    public Map<String,String> requestParams(@RequestParam("name") String name, HttpServletRequest request) {

        log.info("接收参数 name :{}", name);

        String token = request.getHeader("token");
        log.info("接收请求头 token :{}", token);

        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("token",token);

        return map;
    }

    @RequestMapping("/requestBody")
    public Map<String,Object> requestBody(@RequestBody User user, HttpServletRequest request) {

        log.info("接收参数 user :{}", user);

        String token = request.getHeader("token");
        log.info("接收请求头 token :{}", token);

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("token",token);

        return map;
    }

}
