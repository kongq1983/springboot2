package com.kq.mybatis.mapper;

import com.kq.mybatis.ApplicationBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 * @author kq
 * @date 2020-09-23 17:41
 * @since 2020-0630
 */
public class AccountNoParameterMapperTest extends ApplicationBaseTest {

    @Autowired
    private AccountNoParameterMapper accountNoParameterMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testAdd1(){
        accountNoParameterMapper.addAccountNoId1("test","123456",new Date());
    }

    @Test
    public void addOne(){

        accountMapper.addAccountOne("oneone");
        accountMapper.addAccountOne1("one1one1");

    }

}
