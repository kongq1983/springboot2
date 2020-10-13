package com.kq.aop.proxyfactorybean.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-10-13 16:51
 * @since 2020-0630
 */

@Component("myAspect")
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
        check_Permissions();

        //执行目标方法
        Object obj = arg0.proceed();

        log();

        return obj;
    }

    private void check_Permissions() {
        System.out.println("模拟检查权限");
    }

    private void log(){
        System.out.println("模拟记录日志");
    }

}
