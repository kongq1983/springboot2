package com.kq.scan.mybatis1.mapper;

import com.kq.entity.Account;
import com.kq.scan.common.MybatisBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * AccountMapper
 *
 * @author1 kq
 * @date 2019-10-12
 */
public interface Account1Mapper extends MybatisBaseMapper {

    @Select("select id,username,phone,province,createTime from account limit 20")
    public List<Account> getAccountList();

}
