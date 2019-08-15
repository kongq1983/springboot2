package org.springframework.util.unit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DataSizeTest
 * 处理byte KB MB GB 转化的工具类
 * @author kq
 * @date 2019-08-15
 */
public class DataSizeTest {


    @Test
    public void testSize(){

        DataSize size = DataUnit.MEGABYTES.size();
        System.out.println("size="+size);

        assertEquals(size.toBytes(),1024*1024);

        size = DataSize.ofKilobytes(1024*1024*2);

        assertEquals(2,size.toGigabytes()); //

        size = DataSize.ofMegabytes(2);

        assertEquals(2*1024,size.toKilobytes()); //


    }

}
