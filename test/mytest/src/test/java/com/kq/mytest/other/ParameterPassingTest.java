package com.kq.mytest.other;


import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Random;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterPassingTest {

    /**
     * 多个test之间  共享变量  需要static
     * 如果不是static 则testEdit testRemove 得不到id
     */
    private static String id;

    /** 需要static */
    @BeforeClass
    public static void beforeClass(){
        log.info("enter test beforeClass method ");
    }

    @Before
    public void begin(){
        log.info("enter test begin method id={}",id);
    }

    @Test
    public void testAdd (){
        this.id = new Random().nextLong()+"";
        log.info("enter test add method id={}",id);
    }


    @Test
    public void testEdit(){
        log.info("enter test edit method id={}",id);
    }

    @Test
    public void testRemove(){
        log.info("enter test remove method id={}",id);
    }

    @After
    public void testDown(){
//        log.info("enter test testDown method id={}",id);
        log.info("enter test testDown method ");
    }


    /** 需要static */
    @AfterClass
    public static void afterClass(){
        log.info("enter test afterClass method ");
    }
}
