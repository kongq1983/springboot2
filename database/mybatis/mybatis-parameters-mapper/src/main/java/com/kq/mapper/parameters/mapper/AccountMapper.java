package com.kq.mapper.parameters.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * AccountMapper
 *
 * @author1 kq
 * @date 2019-10-12
 */
@Mapper
public interface AccountMapper {

    @Insert("insert into account(username) values(#{abc})")
    void addAccountOne(String username);

    @Select("select id,username,phone,province,createTime from account limit 20")
    public List<Account> getAccountList();

    @Insert("insert into account(username,phone,createTime) values(#{username},#{phone},#{createTime})")
    void addAccountNoId(Account account);

    @Insert("insert into account(username,phone,createTime) values(#{username},#{a.phone},#{a.createTime})")
    void addAccountNoId1(@Param("a") Account account, @Param("username") String username);


    @Insert("insert into account(username,phone,createTime) values(#{username},#{phone},#{createTime})")
    void addAccountNoId2(@Param("username") String username, @Param("phone") String phone, @Param("createTime") Date createTime);

    @Insert("insert into account(username,phone,createTime) values(#{username},#{phone},#{createTime})")
    void addAccountNoId22(String username, String phone, Date createTime);

    @Insert("insert into account(username,phone,createTime) values(#{username},#{account.phone},#{account.createTime})")
    void addAccountNoId3(Account account, String username);

    @Insert("insert into account(username,phone,createTime) values(#{param2},#{param1.phone},#{param1.createTime})")
    void addAccountNoId4(Account account, String username);

    @Insert("insert into account(username,phone,createTime) values(#{1},#{0.phone},#{0.createTime})")
    void addAccountNoId5(Account account, String username);

    @Insert("insert into account(username,phone,createTime) values(#{param2},#{0.phone},#{0.createTime})")
    void addAccountNoId6(Account account, String username);

}
