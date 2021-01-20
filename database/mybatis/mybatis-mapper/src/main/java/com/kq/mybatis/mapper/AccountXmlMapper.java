package com.kq.mybatis.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author kq
 * @date 2020-09-24 15:54
 * @since 2020-0630
 */
@Mapper
public interface AccountXmlMapper {

    public void addAccount(Account account);

    @Select("select id,username,phone,province,createTime from account where id=#{id}")
    public Account getAccountById(Long id);

    public List<Account> getAccountList(@Param("ids")List<Integer> ids, @Param("username")String username,@Param("province") String province);

//    @Select("select province from ${tablename} where id=#{id}")
    public String getUsername(@Param("tablename") String tablename,@Param("id")Long id);

}
