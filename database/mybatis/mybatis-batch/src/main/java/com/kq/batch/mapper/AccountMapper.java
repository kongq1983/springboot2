package com.kq.batch.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    @Select("select id,username,phone,province,createTime from account where id=#{id}")
    public Account getAccount(@Param("id") Long id);

    /**
     * 验证username
     * @param username
     * @return
     */
    @Select("select count(username) from account where username=#{username}")
    public int checkUserName(@Param("username") String username);

    @Insert("insert into account(username,phone,createTime) values(#{username},#{phone},#{createTime})")
    void addAccountNoId(Account o);


    @Insert("insert into account(id,username,phone,createTime) values(#{id},#{username},#{phone},#{createTime})")
    void addAccountId(Account o);

}
