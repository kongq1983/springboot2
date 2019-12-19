package com.kq.mytest.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MyStringUtilTest
 *
 * @author kq
 * @date 2019-12-16
 */
public class MyStringUtilTest {

    @Test
    public void trimTest(){
        String result = MyStringUtil.trim("123  ");

        assertThat(result.equals("123"));

    }

}
