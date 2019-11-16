package com.kq.jdbc1.dao;

import com.kq.jdbc1.entity.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * AccountDao
 *
 * @author kq
 * @date 2019-10-11
 */
@Repository
public class AccountDao extends BaseDao{

    /**
     * 获取账号列表
     * @return
     */
    public List<Account> getAccountList(){

        String sql = "select id,username,phone,province,createtime from account";
        List<Account> list = this.jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int i) throws SQLException {

                Account account = new Account();
                account.setId(rs.getLong("id"));
                account.setPhone(rs.getString("phone"));
                account.setUsername(rs.getString("username"));
                account.setProvince(rs.getString("province"));
                account.setCreateTime(rs.getDate("createtime"));

                return account;
            }
        });

        return list;
    }

    public void updateName(Long id,String name) {
        String sql = "update account set name=? where id=?";
        jdbcTemplate.update(sql,name,id);
    }

    public void insert(Account account) {
        String sql = "insert into account(id,username,phone,createtime) values(?,?,?,?)";

        jdbcTemplate.update(sql,account.getId(),account.getUsername(),account.getPhone(),new Date());

    }


}
