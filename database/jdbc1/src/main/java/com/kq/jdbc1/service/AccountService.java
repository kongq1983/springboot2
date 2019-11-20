package com.kq.jdbc1.service;

import com.kq.jdbc1.entity.Account;

import java.util.List;

/**
 * AccountService
 *
 * @see org.springframework.transaction.support.DefaultTransactionDefinition
 * @date 2019-11-08
 */
public interface AccountService {

    /**
     * 修改名称
     * @param id
     * @param name
     */
    public void updateName(Long id,String name);

    /**
     * 同个service
     * account1 PROPAGATION_REQUIRES_NEW
     * account2 PROPAGATION_REQUIRED
     * 插入数据
     * @param account1
     * @param account2
     */
    public void insert(Account account1, Account account2);


    /**
     * 两个不同的service
     * account1 PROPAGATION_REQUIRES_NEW
     * account2 PROPAGATION_REQUIRED
     * 插入数据
     * @param account1
     * @param account2
     */
    public void insert2(Account account1, Account account2);


    /**
     * 获取账号列表
     * @return
     */
    public List<Account> getAccountList();

}
