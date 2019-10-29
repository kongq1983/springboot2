package com.kq.jdbc2.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * BaseDao
 *
 * @author kq
 * @date 2019-10-11
 */
public class BaseDao {

    @Resource(name="jdbcTemplateDs1")
    protected JdbcTemplate jdbcTemplateDs1;

    @Resource(name="jdbcTemplateDs2")
    protected JdbcTemplate jdbcTemplateDs2;

}
