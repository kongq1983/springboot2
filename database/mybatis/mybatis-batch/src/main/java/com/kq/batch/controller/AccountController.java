package com.kq.batch.controller;

import com.kq.batch.mapper.AccountMapper;
import com.kq.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/view")
    public Account view(@RequestParam("id") Long id){
        return accountMapper.getAccount(id);
    }


}
