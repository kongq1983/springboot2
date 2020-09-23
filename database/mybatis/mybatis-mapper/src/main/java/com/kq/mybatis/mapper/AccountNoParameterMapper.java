package com.kq.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * 这个是没有指定-parameters参数
 * 注意arg从0开始   param从1开始
 * @author kq
 * @date 2020-09-23 17:35
 * @since 2020-0630
 */
@Mapper
public interface AccountNoParameterMapper {

    @Insert("insert into account(username,phone,createTime) values(#{arg0},#{arg1},#{param3})")
    void addAccountNoId1(String username,String phone,Date createTime);

}
