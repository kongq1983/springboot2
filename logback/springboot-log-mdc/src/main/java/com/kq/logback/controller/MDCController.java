package com.kq.logback.controller;

import com.kq.logback.task.PrintTask;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author kq
 * @date 2021-07-26 9:12
 * @since 2020-0630
 */
//@Slf4j
@RestController
public class MDCController {

    protected Logger log = LoggerFactory.getLogger(MDCController.class);

    // http://localhost:10013/user/add?id=100
    @RequestMapping("/user/add")
    public Map<String,String> add(@RequestParam("id") Long id) {

//        String randomId = new Random().nextInt(10000)+"";

//        MDC.put("mdcTraceId",randomId);

//        log.info("user add , id={} randomId={}", id,randomId);
        log.info("user add , id={} randomId={}", id);
        Map<String,String> map = new HashMap<>();
        map.put("result","ok");
        return map;

    }


}
