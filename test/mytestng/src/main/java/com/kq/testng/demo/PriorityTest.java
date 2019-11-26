package com.kq.testng.demo;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = 3)
    public void test3() {
        System.out.println("invoke test3");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("invoke test2");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("invoke test1");
    }



}
