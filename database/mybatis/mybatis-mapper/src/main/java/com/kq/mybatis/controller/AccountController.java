package com.kq.mybatis.controller;

import com.kq.entity.Account;
import com.kq.mybatis.mapper.AccountMapper;
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
    private AccountMapper accountMapper;

    @RequestMapping("/list")
    public List<Account> list(){

        return accountMapper.getAccountList();

    }


}
