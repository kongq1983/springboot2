package com.kq.mytest.util;

/**
 * MyStringUtil
 *
 * @author kq
 * @date 2019-12-16
 */
public class MyStringUtil {

    private MyStringUtil(){

    }

    public static String trim(String str)  {
        if(str==null) return null;

        return str.trim();

    }

    public static boolean isBlank(String str)  {
        if(str==null||str.trim().length()==0) return true;
        return false;

    }


}
