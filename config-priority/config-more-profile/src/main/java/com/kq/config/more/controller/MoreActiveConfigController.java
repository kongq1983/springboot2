package com.kq.config.more.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoreActiveConfigController {

    @Value("${mysql.server.url:localhost}")
    private String mysqlServerUrl;

    @Value("${mongodb.server.url:localhost}")
    private String mongoDbServerUrl;

    @Value("${test.server.url:localhost}")
    private String tesetServerUrl;


    @Value("${read.include.file:-1}")
    private String readIncludeFile;




    @RequestMapping("/serverUrl")
    public String serverMyName(){
        StringBuilder str = new StringBuilder();
        str.append("mysqlServerUrl=").append(mysqlServerUrl);
        str.append("  <br/>");
        str.append("mongoDbServerUrl=").append(mongoDbServerUrl);
        str.append("  <br/>");
        str.append("tesetServerUrl=").append(tesetServerUrl);
        str.append("  <br/>");
        str.append("readIncludeFile=").append(readIncludeFile);
        return str.toString();

    }

}
