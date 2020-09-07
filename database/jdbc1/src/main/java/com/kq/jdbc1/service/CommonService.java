package com.kq.jdbc1.service;

import com.kq.jdbc1.entity.Account;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommonService
 *
 * @author kq
 * @date 2020-01-06
 */
public interface CommonService {


    @Transactional(propagation= Propagation.REQUIRED)
    public void insert(Account account);


}
