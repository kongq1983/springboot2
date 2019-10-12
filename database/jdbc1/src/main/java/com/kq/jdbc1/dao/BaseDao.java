package com.kq.jdbc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * BaseDao
 *
 * @author kq
 * @date 2019-10-11
 */
public class BaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
