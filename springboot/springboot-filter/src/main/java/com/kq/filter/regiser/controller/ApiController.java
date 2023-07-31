package com.kq.filter.regiser.controller;

import com.kq.dto.DtoResult;
import com.kq.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kq
 * @date 2021-05-17 9:32
 * @since 2020-0630
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiController {


    @RequestMapping("/time")
    public DtoResult sysInfo(HttpServletRequest request){

        log.info("调用获取当前时间");

        DtoResult result = new DtoResult();
        result.setResult(String.valueOf(System.currentTimeMillis()));

        return result;

    }


    @RequestMapping(value="/employee",method = RequestMethod.POST)
    public DtoResult post(@RequestBody Employee e) {
        log.info("进入保存用户接口  e={}",e);

        DtoResult result = new DtoResult();
        result.setResult(e);

        return result;
    }


}
