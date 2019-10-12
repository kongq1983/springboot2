package com.kq.jdbc2.controller;

import com.kq.entity.Account;
import com.kq.jdbc2.dao.ds1.AccountDs1Dao;
import com.kq.jdbc2.dao.ds2.AccountDs2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountController
 *
 * @author kq
 * @date 2019-10-11
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDs1Dao accountDs1Dao;

    @Autowired
    private AccountDs2Dao accountDs2Dao;

    @RequestMapping("/ds1/list")
    public List<Account> list1(){

        return accountDs1Dao.getAccountList();

    }

    @RequestMapping("/ds2/list")
    public List<Account> list2(){

        return accountDs2Dao.getAccountList();

    }


}
