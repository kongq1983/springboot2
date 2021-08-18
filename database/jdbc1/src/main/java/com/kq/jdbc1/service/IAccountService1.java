package com.kq.jdbc1.service;

import com.kq.jdbc1.entity.Account;

/**
 * @author kq
 * @date 2021-03-09 13:51
 * @since 2020-0630
 */
public interface IAccountService1 {

    /**
     * 同个service
     * account1 PROPAGATION_REQUIRES_NEW
     * account2 PROPAGATION_REQUIRED
     * 插入数据
     * @param account1
     * @param account2
     */
    public void insert1(Account account1, Account account2);


    public void insert2(Account account);

    public void insert3(Account account);


}
