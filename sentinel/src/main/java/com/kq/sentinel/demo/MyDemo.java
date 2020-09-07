package com.kq.sentinel.demo;

/**
 * MyDemo
 *
 * @author kq
 * @date 2019-11-30
 */
public class MyDemo {

    public static void main(String[] args) {
        long num = 1575095617070l % 500;

        System.out.println("num="+num);

        int n = 1/1000;
        System.out.println("n="+n);
        n = 999/1000;
        System.out.println("n="+n);
        n = 1999/1000;
        System.out.println("n="+n);

    }

}
