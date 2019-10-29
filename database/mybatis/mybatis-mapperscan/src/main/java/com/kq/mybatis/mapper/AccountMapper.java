package com.kq.mybatis.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * AccountMapper
 *
 * @author1 kq
 * @date 2019-10-12
 */
public interface AccountMapper {

    @Select("select id,username,phone,province,createTime from account limit 20")
    public List<Account> getAccountList();

}
