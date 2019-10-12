package com.kq.jdbc1.controller;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
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
    private AccountDao accountDao;

    @RequestMapping("/list")
    public List<Account> list(){

        return accountDao.getAccountList();

    }


}
