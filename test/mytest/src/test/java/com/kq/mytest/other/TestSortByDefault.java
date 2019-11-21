package com.kq.mytest.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * TestSortByDefault
 * 执行顺序 1 - 3 - 2
 * @author kq
 * @date 2019-11-21
 */
@FixMethodOrder(MethodSorters.DEFAULT)
@Slf4j
public class TestSortByDefault {
    @Test
    public void testFirst() throws Exception {
        log.info("------1--------");
    }

    @Test
    public void testSecond() throws Exception {
        log.info("------2--------");

    }

    @Test
    public void testThird() throws Exception {
        log.info("------3--------");
    }


}
