package org.springframework.util;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Properties;

public class PropertyPlaceholderHelperTest {

    PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");

    /**
     * 单个变量
     */
    @Test
    public void test(){

        String text = "name=${name}";
        Properties props = new Properties();
        props.setProperty("name", "admin");

        String result = helper.replacePlaceholders(text, props);

        assertEquals(result,"name=admin");

    }

    /**
     * 多个变量
     */
    @Test
    public void testMore(){

        String text = "name=${name},age=${age}";
        Properties props = new Properties();
        props.setProperty("name", "admin");
        props.setProperty("age", "18");

        String result = helper.replacePlaceholders(text, props);

        assertEquals(result,"name=admin,age=18");

    }

    /**
     * 递归
     */
    @Test
    public void testRecursion(){

        String text = "message=${message}";
        Properties props = new Properties();
        props.setProperty("message", "hi,${name}");
        props.setProperty("name", "admin");

        String result = helper.replacePlaceholders(text, props);

        assertEquals(result,"message=hi,admin");

    }

    /**
     * 其他符号
     */
    @Test
    public void testOtherMark(){

        helper = new PropertyPlaceholderHelper("$#", "#");

        String text = "name=$#name#,age=$#age#";
        Properties props = new Properties();
        props.setProperty("name", "admin");
        props.setProperty("age", "18");

        String result = helper.replacePlaceholders(text, props);

        assertEquals(result,"name=admin,age=18");


    }

}
