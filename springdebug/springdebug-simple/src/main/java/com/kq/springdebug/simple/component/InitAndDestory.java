package com.kq.springdebug.simple.component;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * InitAndDestory
 *
 * @author kq
 * @date 2019-12-25
 */
@Component
public class InitAndDestory implements InitializingBean, DisposableBean {

    public InitAndDestory(){
        System.out.println("InitAndDestory init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化 InitializingBean afterPropertiesSet call");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁 DisposableBean destory call");
    }

    @PostConstruct
    public void annoationInit(){
        System.out.println("初始化 InitializingBean PostConstruct annoationInit.call");
    }

    @PostConstruct
    public void annoationInit1(){
        System.out.println("初始化 InitializingBean PostConstruct annoationInit1.call");
    }

    @PreDestroy
    public void annoationDestroy() throws Exception {
        System.out.println("销毁 DisposableBean PreDestroy call");
    }

}
