package com.kq.aop.proxyfactorybean;

import com.kq.aop.proxyfactorybean.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2020-10-13 16:59
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.aop.proxyfactorybean")
public class SpringAopProxyFactoryBeanApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAopProxyFactoryBeanApplication.class);

        UserDao userDao=(UserDao) context.getBean("userDaoProxy");
        //执行方法
        userDao.addUser();
        userDao.addUser();

    }

}
