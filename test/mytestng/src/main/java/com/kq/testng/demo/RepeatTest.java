package com.kq.testng.demo;


import org.testng.annotations.Test;

public class RepeatTest {

    /**
     * invocationCount=3 循环3次
     */
    @Test(priority = 1, invocationCount = 3)
    public void test1() {
        System.out.println("invoke test1");
    }

}
