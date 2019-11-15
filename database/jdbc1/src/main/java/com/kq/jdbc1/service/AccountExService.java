package com.kq.jdbc1.service;

import com.kq.jdbc1.entity.Account;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountService
 *
 * @see org.springframework.transaction.support.DefaultTransactionDefinition
 * @date 2019-11-08
 */
public interface AccountExService {


    /**
     * account1 PROPAGATION_REQUIRES_NEW
     * 插入数据
     * @param account
     */
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insert(Account account);

}
