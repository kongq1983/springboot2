package com.kq.aop.minial;

import com.kq.aop.minial.advice.MyAfterAdvice;
import com.kq.aop.minial.advice.MyBeforeAdvice;
import com.kq.aop.minial.advice.MyBeforeAdvice1;
import com.kq.aop.minial.pojo.Pojo;
import com.kq.aop.minial.pojo.SimplePojo;
import org.springframework.aop.framework.ProxyFactory;

/** DefaultAdvisorAdapterRegistry默认支持支持MethodBeforeAdvice、AfterReturningAdvice、ThrowsAdvice 或者MethodInterceptor
 * @author kq
 * @date 2020-10-12 18:38
 * @since 2020-0630
 */
public class SimplePojoMoreAdviceDemo {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new MyBeforeAdvice());
        factory.addAdvice(new MyAfterAdvice());
        factory.setExposeProxy(true); // AopContext.currentProxy()) 要使用setExposeProxy=true

        Pojo pojo = (Pojo) factory.getProxy(); // JdkDynamicAopProxy
        // this is a method call on the proxy!
        pojo.foo();
//        pojo.foo1();
    }

}
