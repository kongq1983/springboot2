package com.kq.springdebug.resourcedi;

import com.kq.entity.Account;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Account> {

    @Override
    public Account getObject() throws Exception {

        Account account = new Account();
        account.setId(1l);
        account.setPhone("13600001111");

        return account;
    }

    @Override
    public Class<?> getObjectType() {
        return Account.class;
    }


    @Override
    public String toString() {
        return "MyFactoryBean{}";
    }
}
