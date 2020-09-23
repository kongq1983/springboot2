package com.kq.mybatis.parameters.mapper;

import com.kq.mapper.parameters.mapper.AccountMapper;
import com.kq.mybatis.parameters.ApplicationBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Java 8 编译，并且指定-parameters，并且mybatis版本3.4.1及之后版本
 * @author kq
 * @date 2020-09-23 17:41
 * @since 2020-0630
 */
public class AccountMapperTest extends ApplicationBaseTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testAddAccountNoId22(){
        accountMapper.addAccountNoId22("test1","12345678",new Date());
    }


    @Test
    public void addOne(){

        accountMapper.addAccountOne("oneone");

    }


}
