package com.kq.batch.service;

import com.kq.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 插入多个
     * @param list
     */
    public void insertList(List<Account> list);

    public void insertTest(int size);

}
