package com.kq.aop.minial;

import com.kq.aop.minial.advice.MyBeforeAdvice;
import com.kq.aop.minial.pojo.Pojo;
import com.kq.aop.minial.pojo.SimplePojo;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author kq
 * @date 2020-10-12 16:04
 * @since 2020-0630
 */
public class SimplePojoDemo {

    public static void main1(String[] args) {
        Pojo pojo = new SimplePojo();
        // this is a direct method call on the 'pojo' reference
        pojo.foo();
    }

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new MyBeforeAdvice());

        Pojo pojo = (Pojo) factory.getProxy();
        // this is a method call on the proxy!
        pojo.foo();
    }

}
