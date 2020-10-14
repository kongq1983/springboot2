package com.kq.aop.minial.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author kq
 * @date 2020-10-12 19:32
 * @since 2020-0630
 */
public class MyAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAfterAdvice after is call.");
        System.out.println("method="+method.getName());

        System.out.println("target="+target);
    }
}
