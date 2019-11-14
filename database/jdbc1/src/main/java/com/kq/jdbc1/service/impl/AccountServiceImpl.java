package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.exception.ZyxtBaseRuntimeException;
import com.kq.jdbc1.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void insert(Account account1, Account account2) {

    }

}
