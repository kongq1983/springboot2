package com.kq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getFormat() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

}
