package com.kq.aop.minial.advice;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author kq
 * @date 2020-10-12 18:38
 * @since 2020-0630
 */
public class MyBeforeAdvice1 implements Advice, MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("start MyBeforeAdvice1 "+invocation.getMethod().getName());
        Object result = invocation.proceed(); // ReflectiveMethodInvocation
        System.out.println("e-n-d MyBeforeAdvice1 "+invocation.getMethod().getName());
        return result;
    }
}
