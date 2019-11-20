package com.kq.jdbc1.service;

import com.kq.jdbc1.BaseTest;
import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;

/**
 * AccountServiceImplMockTest
 * https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-tests
 * @author kq
 * @date 2019-11-20
 */
public class AccountServiceImplMockTest extends BaseTest {

    @MockBean
    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;


    @Test
    public void testList(){

        List<Account> accountList = new ArrayList<>();
        Account account = new Account();
        account.setUsername("king");

        Account account1 = new Account();
        account1.setUsername("root");

        accountList.add(account);
        accountList.add(account1);

        given(this.accountService.getAccountList()).willReturn(accountList);

        System.out.println("accountList="+accountService.getAccountList());

    }


}
