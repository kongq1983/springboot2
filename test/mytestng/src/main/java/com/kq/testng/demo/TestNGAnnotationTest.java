package com.kq.testng.demo;

import org.testng.annotations.*;

/**
 * beforeSuite -> beforeTest -> beforeClass
 * beforeMethod  -> test -> afterMethod
 * afterClass -> afterTest -> afterSuite
 */
public class TestNGAnnotationTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " afterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(this.getClass().getName() + " beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(this.getClass().getName() + " afterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " afterClass");
    }

    @BeforeMethod
    public void beofreMethod() {
        System.out.println(this.getClass().getName() + " beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(this.getClass().getName() + " afterMethod");
    }



    @Test(priority = 2, invocationCount = 2)
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }

    /**
     * priority: 数值越低  优先级越高
     * 优先级高  循环调用3次
     */
    @Test(priority = 1, invocationCount = 3)
    public void test1() {
        System.out.println(this.getClass().getName() + " test1");
    }

}
