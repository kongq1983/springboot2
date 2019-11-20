package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.exception.ZyxtBaseRuntimeException;
import com.kq.jdbc1.service.AccountExService;
import com.kq.jdbc1.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kq
 * @date 2019-11-08
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountExService accountExService;

    @Transactional
    @Override
    public void updateName(Long id, String name) {

        System.out.println("--------------------1-----------------------");

        accountDao.updateName(1l,"hello");
        updateName1(2l,"name12345678901234567890");


//        try {
//            updateName1(2l,"name12345678901234567890");
//        }catch (Exception e){
//            log.error("保存报错!",e);
//        }


        System.out.println("--------------------2-----------------------");

    }


    @Transactional
    public void updateName1(Long id, String name) {

        System.out.println(1 / 0);

//        if(id.longValue()==2){
//            throw new ZyxtBaseRuntimeException("10812300","id等于2");
//        }
//        accountDao.updateName(id,name);
    }

    @Transactional
    @Override
    public void insert(Account account1, Account account2) {
        this.insertAccount1(account1); //虽然加了Propagation.REQUIRES_NEW，事务还是会回滚掉 本意是要提交

        accountDao.insert(account2);  //本数据报错
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insertAccount1(Account account1) {

        accountDao.insert(account1);

    }

    @Transactional
    @Override
    public void insert2(Account account1, Account account2) {

        accountExService.insert(account1);  //事务会提交
        accountDao.insert(account2);  //本数据报错

    }


    public List<Account> getAccountList() {
        List<Account> list = accountDao.getAccountList();
        if(list!=null) {
            for(Account account : list) {
                account.setUsername("my:"+account.getUsername());
            }
        }

        return list;
    }


}
