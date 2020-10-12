package com.kq.aop.minial.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author kq
 * @date 2020-10-12 16:07
 * @since 2020-0630
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("RetryAdvice before is call.");
        System.out.println("method="+method.getName());

        System.out.println("args="+args);
        System.out.println("target="+target);

    }
}
