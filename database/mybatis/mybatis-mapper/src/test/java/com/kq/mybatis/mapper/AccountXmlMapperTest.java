package com.kq.mybatis.mapper;

import com.kq.entity.Account;
import com.kq.mybatis.ApplicationBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author kq
 * @date 2020-09-24 16:24
 * @since 2020-0630
 */
public class AccountXmlMapperTest extends ApplicationBaseTest {

    @Autowired
    private AccountXmlMapper accountXmlMapper;

    @Test
    public void testAdd(){
        Account a = new Account();
        a.setUsername("aaa");
        accountXmlMapper.addAccount(a);

        System.out.println("a.id="+a.getId());

        assertThat(a.getId(),notNullValue());

//        assertThat(true,equalTo(metaClass.hasGetter("id")));
    }

    @Test
    public void testGetById(){
        Account account = accountXmlMapper.getAccountById(1L);

        assertThat(account,notNullValue());
    }

    @Test
    public void testGetAccountList1() {
        Account a = new Account();
        a.setUsername("aaa");
        a.setProvince("zj");
        List<Account> list = this.accountXmlMapper.getAccountList1(a);

        System.out.println("list="+list);

    }

}
