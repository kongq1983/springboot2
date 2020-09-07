package com.kq.jdbc1.service.impl;

import com.kq.jdbc1.dao.PersonDao;
import com.kq.jdbc1.dao.UserDao;
import com.kq.jdbc1.entity.Person;
import com.kq.jdbc1.entity.User;
import com.kq.jdbc1.service.PersonService;
import com.kq.jdbc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 *
 * @author kq
 * @date 2020-01-06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}
