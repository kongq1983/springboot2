package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.service.AccountExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountExServiceImpl
 *
 * @author kq
 * @date 2019-11-14
 */
@Service
public class AccountExServiceImpl implements AccountExService {

    @Autowired
    private AccountDao accountDao;

//    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @Override
    public void insert(Account account) {
        accountDao.insert(account);
    }

}
