package com.kq.util;

import org.junit.Test;

/**
 * LongTest
 *
 * @author kq
 * @date 2019-09-04
 */
public class LongTest {

    @Test
    public void testNum(){
        long num = 1229484162420736L;
//        long num = 1229484162420737L;
//        long num = 1229484162420738L;

        String numStr = BinaryUtil.toBinaryString(num);
        System.out.println("numStr="+numStr+"  length="+numStr.length());

        System.out.println(numStr.substring(0,1));
        System.out.println(numStr.substring(1,42)+"  length="+numStr.substring(1,42).length());
        System.out.println(numStr.substring(42,52));
        System.out.println(numStr.substring(52,numStr.length()));

        String numStr1 = Long.toBinaryString(5l);
        System.out.println("numStr1="+numStr1+"  length="+numStr1.length());
        String numStr2 = Long.toOctalString(5l);
        System.out.println("numStr2="+numStr2+"  length="+numStr2.length());


    }

    @Test
    public void testAbc(){
        byte sequenceOffset = 110;
        sequenceOffset = (byte) (~sequenceOffset & 1);
        System.out.println("sequenceOffset="+sequenceOffset);

        // 0000 0011
        byte num = 3;
        // 1111 1100 (原码取反)
        byte otherNum = (byte) (~num);

        System.out.println("otherNum="+otherNum);


    }


}
