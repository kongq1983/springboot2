package com.kq.jdbc1.controller;

import com.kq.jdbc1.BaseTest;
import com.kq.jdbc1.dao.AccountDao;
import com.kq.jdbc1.mockdata.AccountData;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AccountControllerSelfTest
 *
 * @author kq
 * @date 2019-11-20
 */
public class AccountControllerSelfTest extends BaseTest {

    @MockBean
    private AccountDao accountDao;

    @Test
    public void list() throws Exception{

        MockHttpServletRequestBuilder builder = post("/account/list");
        builder.content("{}");
        builder.contentType(MediaType.APPLICATION_JSON);

        System.out.println("accountDao="+accountDao);

        given(this.accountDao.getAccountList()).willReturn(AccountData.getAccountList());

        perform(builder).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(AccountData.getAccountList().size()));


    }


    @Test
    public void testMapResult() throws Exception{

        MockHttpServletRequestBuilder builder = post("/account/daoListResult");
        builder.content("{}");
        builder.contentType(MediaType.APPLICATION_JSON);

        System.out.println("accountDao="+accountDao);

        given(this.accountDao.getAccountList()).willReturn(AccountData.getAccountList());

        //返回值
//        {"result":[{"id":null,"username":"king","phone":null,"province":null,"createTime":null},
//            {"id":null,"username":"root","phone":null,"province":null,"createTime":null}],
//            "code":"16800000","success":true}

        perform(builder).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                    .andExpect(MockMvcResultMatchers.jsonPath("@.code").value("16800000"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.result.length()").value(2));

//        .extractingJsonPathStringValue("@.make")
//                .isEqualTo("Honda")


    }


}
