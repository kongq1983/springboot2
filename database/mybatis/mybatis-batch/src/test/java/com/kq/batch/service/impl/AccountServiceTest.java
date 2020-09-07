package com.kq.batch.service.impl;


import com.kq.batch.ApplicationBaseTest;
import com.kq.batch.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends ApplicationBaseTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testInsert(){
//        accountService.insertTest(10000);
        accountService.insertTest(2);
    }
    // record
    //1 .batch 插入10000条数据，花费5055ms

}
