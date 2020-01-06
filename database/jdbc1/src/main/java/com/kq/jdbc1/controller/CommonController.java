package com.kq.jdbc1.controller;

import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CommonController
 *
 * @author kq
 * @date 2020-01-06
 */

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @RequestMapping("/add")
    public String add(Account account){
        log.debug("-----------------start accountService add : {}",account);
        try {
            commonService.insert(account);
        }catch (Exception e){
            return e.getMessage();
        }
        return "ok";

    }

}
