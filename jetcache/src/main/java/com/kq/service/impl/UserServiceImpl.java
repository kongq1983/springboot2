package com.kq.service.impl;

import com.kq.dto.User;
import com.kq.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {


    @Override
    public User getUserById(Long userId) {

        User u = new User();
        u.setId(userId);
        u.setName("add:"+userId);
        log.info("==============从数据库读取 . user={}",u);
        return u;
    }


    @Override
    public void update(User u) {

        log.info("update user . user={}",u);
    }

    @Override
    public void delete(Long userId) {
        log.info("delete user . userId={}",userId);
    }
}
