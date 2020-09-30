package com.kq.mybatis.mapper;

import com.kq.mybatis.ApplicationBaseTest;
import com.kq.scan.mybatis.mapper.AccountMapper;
import com.kq.scan.mybatis1.mapper.Account1Mapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author kq
 * @date 2020-09-25 10:21
 * @since 2020-0630
 */
public class Account1MapperTest extends ApplicationBaseTest {

    @Autowired
    private Account1Mapper account1Mapper;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testList(){
        assertThat(account1Mapper.getAccountList(),notNullValue());
        assertThat(accountMapper.getAccountList(),notNullValue());
    }


}
