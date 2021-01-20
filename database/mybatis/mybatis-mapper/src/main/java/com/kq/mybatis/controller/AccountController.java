package com.kq.mybatis.controller;

import com.google.common.collect.Lists;
import com.kq.entity.Account;
import com.kq.mybatis.mapper.AccountMapper;
import com.kq.mybatis.mapper.AccountXmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @Autowired
    protected AccountXmlMapper accountXmlMapper;

    /***
     * http://localhost:10001/account/list
     * @return
     */
    @RequestMapping("/list")
    public List<Account> list(){

        return accountMapper.getAccountList();

    }

    /***
     * http://localhost:10001/account/add?username=hello
     * @return
     */
    @RequestMapping("/add")
    public Long add(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
        account.setUsername(a.getUsername());
        account.setPhone(a.getPhone());
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId(account);

        return account.getId();

    }

    /***
     * http://localhost:10001/account/add1?username=hello
     * @return
     */
    @RequestMapping("/add1")
    public Long add1(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
//        account.setUsername(a.getUsername());
        account.setPhone("add1");
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId1(account,a.getUsername());

        return account.getId();

    }

    /***
     * http://localhost:10001/account/add2?username=hello
     * @return
     */
    @RequestMapping("/add2")
    public Long add2(Account a){


        accountMapper.addAccountNoId2(a.getUsername(),"add2",new Date());

        return null;

    }


    /***
     * http://localhost:10001/account/add3?username=hello
     * @return
     */
    @RequestMapping("/add3")
    public Long add3(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
//        account.setUsername(a.getUsername());
        account.setPhone("add3");
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId3(account,a.getUsername());

        return account.getId();

    }

    /***
     * http://localhost:10001/account/add4?username=hello
     * @return
     */
    @RequestMapping("/add4")
    public Long add4(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
//        account.setUsername(a.getUsername());
        account.setPhone("add4");
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId4(account,a.getUsername());

        return account.getId();

    }

    /***
     * http://localhost:10001/account/add5?username=hello
     * @return
     */
    @RequestMapping("/add5")
    public Long add5(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
//        account.setUsername(a.getUsername());
        account.setPhone("add5");
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId5(account,a.getUsername());

        return account.getId();

    }

    /***
     * http://localhost:10001/account/add6?username=hello
     * @return
     */
    @RequestMapping("/add6")
    public Long add6(Account a){

        Account account = new Account();
        account.setCreateTime(new Date());
//        account.setUsername(a.getUsername());
        account.setPhone("add6");
        account.setProvince(a.getProvince());
        accountMapper.addAccountNoId6(account,a.getUsername());

        return account.getId();

    }

    @RequestMapping("/view/{id}")
    public Account getAccount(@PathVariable("id") Long id){

        Account account = accountXmlMapper.getAccountById(id);

        return account;

    }


    @RequestMapping("/list1")
    public List<Account> getAccountList1(){

        List<Account> list = accountXmlMapper.getAccountList(Lists.newArrayList(1,3,5,7,9),"test","zj");

        return list;

    }

}
