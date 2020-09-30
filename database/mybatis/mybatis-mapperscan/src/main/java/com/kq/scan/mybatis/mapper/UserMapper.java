package com.kq.scan.mybatis.mapper;

import com.kq.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 *
 * @author1 kq
 * @date 2019-10-12
 */
@Mapper
public interface UserMapper {

    public Account getAccount();

}
