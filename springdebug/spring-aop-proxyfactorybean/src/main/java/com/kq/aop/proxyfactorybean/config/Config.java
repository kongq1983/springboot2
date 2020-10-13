package com.kq.aop.proxyfactorybean.config;

import com.kq.aop.proxyfactorybean.aspect.MyAspect;
import com.kq.aop.proxyfactorybean.dao.UserDao;
import com.kq.aop.proxyfactorybean.dao.impl.UserDaoImpl;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2020-10-13 16:52
 * @since 2020-0630
 */
@Configuration
public class Config {

    @Bean("userDaoProxy")
    public ProxyFactoryBean getProxyFactoryBean() throws Exception {

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[]{UserDao.class});
        proxyFactoryBean.setTarget(this.getUserDao());
//        proxyFactoryBean.setTargetName("userDao");
        proxyFactoryBean.setInterceptorNames("myAspect");
//        proxyFactoryBean.setProxyTargetClass(true); // true:cglib  false: jdk

        return proxyFactoryBean;
    }

    @Bean("userDao")
    public UserDao getUserDao(){
        UserDao userDao = new UserDaoImpl();
        return  userDao;
    }

//    @Bean("myAspect")
//    public MyAspect getMyAspect(){
//        MyAspect myAspect = new MyAspect();
//        return myAspect;
//    }

}
