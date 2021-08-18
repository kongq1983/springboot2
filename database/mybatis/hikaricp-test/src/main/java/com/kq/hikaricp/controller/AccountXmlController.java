package com.kq.hikaricp.controller;

import com.kq.entity.Account;
import com.kq.hikaricp.service.AccountXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author kq
 * @date 2021-05-18 10:18
 * @since 2020-0630
 */
@RestController
@RequestMapping("/account")
public class AccountXmlController {

    @Autowired
    private AccountXmlService accountXmlService;


    @RequestMapping("/add")
    public Long add(Account a){
        accountXmlService.addAccount(null);
        return -1l;

    }

    @RequestMapping("/deadlock")
    public Long deadlock(HttpServletRequest request){
        String id = request.getParameter("id");

        Long lid = null;
        if(id==null||id.trim().equals("")) {
            lid = 20l;
        }else {
            lid = Long.valueOf(id);
        }

        accountXmlService.deadlock(lid);

        return lid;

    }

}
