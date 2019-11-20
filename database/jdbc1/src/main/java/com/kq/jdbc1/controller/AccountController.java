package com.kq.jdbc1.controller;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.service.AccountService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDao accountDao;



    @RequestMapping("/list")
    public List<Account> list(){
        log.debug("-----------------start accountService : {}",accountService);
        List<Account> list =  accountService.getAccountList();
        log.debug("-----------------end get accountService account list : {}",list);
        return list;

    }


    @RequestMapping("/daoList")
    public List<Account> daoList(){
        log.debug("-----------------start accountDao : {}",accountDao);
        List<Account> list =  accountDao.getAccountList();
        log.debug("-----------------end accountDao account list : {}",list);
        return list;

    }


}
