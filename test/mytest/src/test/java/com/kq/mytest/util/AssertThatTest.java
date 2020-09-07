package com.kq.mytest.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/**
 * AssertThatTest
 * @author kq
 * @date 2019-12-27
 */
public class AssertThatTest {

    @Test
    public void numberTest(){

        int num = 50;
        /**数值匹配**/
        //测试变量是否大于指定值
        assertThat(num, greaterThan(30));
        //测试变量是否小于指定值
        assertThat(num, lessThan(100));
        //测试变量是否大于等于指定值
        assertThat(num, greaterThanOrEqualTo(50));
        //测试变量是否小于等于指定值
        assertThat(num, lessThanOrEqualTo(100));

    }


    @Test
    public void stringTest(){
        String str = "helloworld";

        assertThat(str,equalTo("helloworld"));
        assertThat(str,startsWith("hello"));
        assertThat(str,endsWith("world"));
        assertThat(str,equalToIgnoringCase("HELLOWORLD"));

    }


    @Test
    public void mapTest(){
        Map<String,String> map = new HashMap<>();
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        assertThat(map, hasKey("one"));
        assertThat(map, hasValue("2"));
        assertThat(map, hasKey(equalTo("one")));

    }


}
