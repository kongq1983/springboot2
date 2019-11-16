package com.kq.jdbc1.service;

import com.kq.jdbc1.BaseTest;
import com.kq.jdbc1.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AccountServiceImplTest
 *
 * @author kq
 * @date 2019-11-08
 */
@Slf4j
public class AccountServiceImplTest extends BaseTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void update(){

        try{
            accountService.updateName(1l,"");
        }catch (Exception e) {
            log.error("数据操作报错!",e);
        }

        log.info("The End------------------------------");
    }


    /**
     * 1个service
     */
    @Test
    public void insert(){

        try{
            Account account1 = getAccount()[0];
            Account account2 = getAccount()[1];
            accountService.insert(account1,account2);
        }catch (Exception e) {
            log.error("数据操作报错!",e);
        }

        log.info("The End------------------------------");
    }

    /**
     * 两个servcie
     */
    @Test
    public void insert2(){

        try{
            Account account1 = getAccount()[0];
            Account account2 = getAccount()[1];
            accountService.insert2(account1,account2);
        }catch (Exception e) {
            log.error("数据操作报错!",e);
        }

        log.info("The End------------------------------");
    }


    private Account[] getAccount(){

        Account[] accounts = new Account[2];

        Account account1 = new Account();
        account1.setId(1l);
        account1.setUsername("admin");

        Account account2 = new Account();
        account2.setId(2l);
        String username2 = "guest";
        for(int i=0;i<32;i++){
            username2+="1";
        }
        account2.setUsername(username2);

        accounts[0] = account1;
        accounts[1] = account2;

        return accounts;
    }

}
