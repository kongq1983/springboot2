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

        DataSize size = DataUnit.MEGABYTES.size(); //MB
        System.out.println("size="+size);

        assertEquals(size.toBytes(),1024*1024);

        size = DataSize.ofKilobytes(1024*1024*2); //2G

        assertEquals(2,size.toGigabytes()); //

        size = DataSize.ofMegabytes(2); //2M

        assertEquals(2*1024,size.toKilobytes()); //


        size = DataSize.ofKilobytes(8); //8K

        assertEquals(8*1024,size.toBytes());

        DataSize fiveM = DataSize.parse("5MB");
        assertEquals(5*1024,fiveM.toKilobytes());

        DataSize fiveKB = DataSize.parse("5KB");
        assertEquals(5,fiveKB.toKilobytes());

        DataSize fiveByte = DataSize.parse("5");
        assertEquals(5,fiveByte.toBytes());


    }

}
