package com.kq.jdbc1;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * BaseTest
 *
 * @author kq
 * @date 2019-11-08
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Jdbc1Application.class)
public class BaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public MockHttpServletRequestBuilder post(String uri){
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post(uri);

//        post.header("userInfo",getUserInfo());
//        post.header("XK-Autho1.0.0","token 123456");
        return post;

    }

    public ResultActions perform(RequestBuilder builder) throws Exception{
        return mockMvc.perform(builder);
    }

    public StatusResultMatchers status(){
        return MockMvcResultMatchers.status();
    }

    public ResultHandler print(){
        return MockMvcResultHandlers.print();
    }


}
