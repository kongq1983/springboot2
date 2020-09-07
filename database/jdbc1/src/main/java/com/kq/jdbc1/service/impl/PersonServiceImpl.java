package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.PersonDao;
import com.kq.jdbc1.entity.Person;
import com.kq.jdbc1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * PersonServiceImpl
 *
 * @author kq
 * @date 2020-01-06
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void insert(Person user) {
        personDao.insert(user);
    }
}
