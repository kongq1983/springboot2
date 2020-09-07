package com.kq.jdbc1.dao;

import com.kq.jdbc1.entity.Person;
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
public class PersonDao extends BaseDao{

    public void insert(Person account) {
        String sql = "insert into person(id,username,phone,createtime) values(?,?,?,?)";

        jdbcTemplate.update(sql,account.getId(),account.getUsername(),account.getPhone(),new Date());

    }

}
