package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.service.IAccountService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 演示如果入口，沒有事務
 * 第2個方法有事務
 * @author kq
 * @date 2021-03-09 13:53
 * @since 2020-0630
 */
@Service
public class AccountService1Impl implements IAccountService1 {

    /**
     * 场景1:
     * insert1没事务
     * insert3(@Transactional)
     * insert2(@Transactional)  抛异常
     *
     * 最终insert1会保存，insert3回滚,insert2回滚
     *---------------------------------------------------------------
     * 场景2:
     * insert1没事务
     * insert3(@Transactional(propagation = Propagation.REQUIRES_NEW))
     * insert2(@Transactional)  抛异常
     *
     * 最终insert1会保存，insert3会保存,insert2回滚
     *
     *
     */

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private IAccountService1 accountService1;

    private boolean isUserProxy = true;

    @Override
    public void insert1(Account account1, Account account2) {

        accountDao.insert(account1); // 不会回滚
//        accountService1.insert2(account2);
        if(isUserProxy){
            accountService1.insert2(account2);
        }else {
            this.insert2(account2);
        }

    }


    @Transactional
    @Override
    public void insert2(Account account) {

        if(isUserProxy) {
            accountService1.insert3(account);
        } else {
            this.insert3(account);
        }

        accountDao.insert(account);

        if(account!=null) {
            throw new RuntimeException("非法参数 account="+account);
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional
    @Override
    public void insert3(Account account) {
        account.setId(account.getId()+1);
        System.out.println("insert3  id="+account.getId());
        accountDao.insert(account);
    }
}
