package com.kq.batch.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;

/**
 * @author kq
 * @date 2020-11-11 17:17
 * @since 2020-0630
 */
public class RandomUtil {


    public static String getGender() {
       int value = ThreadLocalRandom.current().nextInt(2);
        System.out.println(value);
        return value==0?"F":"M";
    }

    public static Date getRandomDate(){

        int year = ThreadLocalRandom.current().nextInt(100);
        int month = ThreadLocalRandom.current().nextInt(12); // 1-12
        int dayOfMonth = 1;
        if(month==2){
            dayOfMonth = ThreadLocalRandom.current().nextInt(28);
        }else {
            dayOfMonth = ThreadLocalRandom.current().nextInt(31); // 1-31
        }
        LocalDate localDate = null;

        month = month<1?1:month;
        dayOfMonth = dayOfMonth<1?1:dayOfMonth;

        try {
            localDate = LocalDate.of(2000 + year, month, dayOfMonth);
        }catch (Exception e){
            System.out.printf("year=%d,month=%d,dayOfMonth=%d",year,month,dayOfMonth);

            e.printStackTrace();
            localDate = LocalDate.now();
        }

        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        return Date.from(instant);
    }


    public static void main(String[] args) {

//        Stream.iterate(1,index->index+1).limit(100).forEach(RandomUtil.getSex());

//        for(int i=0;i<100;i++) RandomUtil.getGender();

        for(int i=0;i<100;i++)System.out.println(getRandomDate());

//        LocalDate.of(2020, 0, 1);
    }

}
