package com.kq.jdbc1.service;

import com.kq.jdbc1.entity.Person;
import com.kq.jdbc1.entity.User;


/**
 * @see org.springframework.transaction.support.DefaultTransactionDefinition
 * @date 2019-11-08
 */
public interface PersonService {

    public void insert(Person user);

}
