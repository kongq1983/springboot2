package com.kq.jdbc1.controller;

import com.kq.jdbc1.BaseTest;
import com.kq.jdbc1.Jdbc1Application;
import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.mockdata.AccountData;
import com.kq.jdbc1.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AccountServiceTest
 * @WebMvcTest情况下，只能mock controller的注入接口、Service
 * 比如account 调用 service , service调用dao ，mock AccountDao，
 * 则Controller得不到数据
 * @author kq
 * @date 2019-11-20
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest { //extends BaseTest{ //BaseTest {

    @MockBean
    private AccountDao accountDao;

    @MockBean
    private AccountService accountService;

    @Autowired
    private MockMvc mvc;


    /**
     * 这个mock过后  accountService.getAccountList是null
     * @throws Exception
     */
    @Test
    public void list() throws Exception{

//        MockHttpServletRequestBuilder builder = post("http://localhost:10001/jdbc1/account/list");
//        builder.content("{}");
//        builder.contentType(MediaType.APPLICATION_JSON);

        System.out.println("accountDao="+accountDao);
        System.out.println("mvc="+mvc);

        given(this.accountDao.getAccountList()).willReturn(AccountData.getAccountList());
//        given(this.accountService.getAccountList()).willReturn(AccountData.getAccountList());

        this.mvc.perform(post("/account/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

//                .andExpect(content().string("Honda Civic"));


    }


    /**
     * 这个mock有用
     * @throws Exception
     */
    @Test
    public void daoLlist() throws Exception{

//        MockHttpServletRequestBuilder builder = post("http://localhost:10001/jdbc1/account/list");
//        builder.content("{}");
//        builder.contentType(MediaType.APPLICATION_JSON);

        System.out.println("accountDao="+accountDao);
        System.out.println("mvc="+mvc);

        given(this.accountDao.getAccountList()).willReturn(AccountData.getAccountList());
//        given(this.accountService.getAccountList()).willReturn(AccountData.getAccountList());

        this.mvc.perform(post("/account/daoList").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

//                .andExpect(content().string("Honda Civic"));


    }

}
