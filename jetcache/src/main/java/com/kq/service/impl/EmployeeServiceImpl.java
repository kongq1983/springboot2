package com.kq.service.impl;

import com.kq.dto.User;
import com.kq.service.IEmployeeService;
import com.kq.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService {


    @Override
    public User getUserById(Long userId) {

        User u = new User();
        u.setId(userId);
        u.setName("add:"+userId);
        log.info("==============从数据库读取 . account={}",u);
        return u;
    }

    @Override
    public User getUserBySearch(Long userId, String name, int type) {
        User u = new User();
        u.setId(userId);
        u.setName("search:"+userId);
        log.info("==============搜索从数据库读取 . account={}",u);
        return u;
    }


    @Override
    public void update(User u) {

        log.info("update account . account={}",u);
    }

    @Override
    public void delete(Long userId) {
        log.info("delete account . accountId={}",userId);
    }
}
