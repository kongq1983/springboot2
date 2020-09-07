package com.kq.jdbc1.dao;

import com.kq.jdbc1.entity.Account;
import com.kq.jdbc1.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * UserDao
 *
 * @author kq
 * @date 2020-01-06
 */
@Repository
public class UserDao extends BaseDao{

    public void insert(User account) {
        String sql = "insert into user(id,username,phone,createtime) values(?,?,?,?)";

        jdbcTemplate.update(sql,account.getId(),account.getUsername(),account.getPhone(),new Date());

    }

}
