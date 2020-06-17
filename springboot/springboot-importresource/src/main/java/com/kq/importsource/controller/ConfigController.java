package com.kq.importsource.controller;

import com.kq.dto.DtoResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${myversion}")
    public String myversion;

    @Value("${author}")
    public String author;

    /**
     * 1. Program arguments  -kk2=223
     * 2. VM options  -Dkk1=123
     * 3. Environment variable (环境变量)
     * java.exe -Dkk1=123  E:\githubproject\java8\target com.kq.environment.SystemDemo --kk2=223
     */
    @Value("${priority}")
    private String priority;

    @RequestMapping("/priority")
    public DtoResult priority(){

        DtoResult result = new DtoResult();
        result.setCode("18800000");
        result.setResult(priority);

        return result;

    }

    @RequestMapping("/myversion")
    public DtoResult myversion(){

        DtoResult result = new DtoResult();
        result.setCode("18800000");
        result.setResult(myversion);

        return result;

    }

    @RequestMapping("/author")
    public DtoResult author(){

        DtoResult result = new DtoResult();
        result.setCode("18800000");
        result.setResult(author);

        return result;

    }

}
