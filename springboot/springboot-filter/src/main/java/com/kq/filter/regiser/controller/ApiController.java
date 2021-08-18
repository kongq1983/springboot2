package com.kq.filter.regiser.controller;

import com.kq.dto.DtoResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kq
 * @date 2021-05-17 9:32
 * @since 2020-0630
 */
@RestController
@RequestMapping("/api")
public class ApiController {


    @RequestMapping("/v1/time")
    public DtoResult sysInfo(HttpServletRequest request){


        DtoResult result = new DtoResult();
        result.setResult(String.valueOf(System.currentTimeMillis()));

        return result;

    }


}
