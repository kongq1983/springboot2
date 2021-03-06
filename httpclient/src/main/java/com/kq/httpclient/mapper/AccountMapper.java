package com.kq.httpclient.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * AccountMapper
 *
 * @author1 kq
 * @date 2019-10-12
 */
@Mapper
public interface AccountMapper {

    @Select("select id,username,phone,province,createTime from account limit 20")
    public List<Account> getAccountList();

}
