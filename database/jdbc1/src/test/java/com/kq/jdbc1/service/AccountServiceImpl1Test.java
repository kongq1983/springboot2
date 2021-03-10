package com.kq.jdbc1.service;

import com.kq.jdbc1.BaseTest;
import com.kq.jdbc1.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author kq
 * @date 2021-03-09 14:12
 * @since 2020-0630
 */
public class AccountServiceImpl1Test extends BaseTest {

    @Autowired
    private IAccountService1 accountService1;

    @Test
    public void insert(){
        long startId = 5;
        Account account1 = new Account();
        account1.setId(startId);
        account1.setUsername("abc"+startId);
        account1.setCreateTime(new Date());


        Account account2 = new Account();
        account2.setId(startId+1);
        account2.setUsername("abc"+(startId+1));
        account2.setCreateTime(new Date());

        accountService1.insert1(account1,account2);

    }


}
