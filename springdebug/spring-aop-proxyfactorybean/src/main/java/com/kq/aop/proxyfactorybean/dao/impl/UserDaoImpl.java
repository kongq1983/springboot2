package com.kq.aop.proxyfactorybean.dao.impl;

import com.kq.aop.proxyfactorybean.dao.UserDao;

/**
 * @author kq
 * @date 2020-10-13 16:49
 * @since 2020-0630
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }

}
