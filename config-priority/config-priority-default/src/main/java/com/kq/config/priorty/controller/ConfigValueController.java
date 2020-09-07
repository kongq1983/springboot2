package com.kq.config.priorty.controller;

import com.kq.dto.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigValueController {

    private String serverMyName;

    @Value("${server.myname}")
    public void setServerMyName(String serverMyName) {
        this.serverMyName = serverMyName;
    }


    @RequestMapping("/serverMyName")
    public String serverMyName(){
        return serverMyName;

    }

}
