package com.kq.springdebug.simple.beanfactoryprocess;

import com.kq.springdebug.simple.service.ICircleA;
import com.kq.springdebug.simple.service.impl.CircleAWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-10-20 13:43
 * @since 2020-0630
 */
@Component
public class MyBeanFactoryProcess implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {

        if(bean instanceof ICircleA) {
            return new CircleAWrapper((ICircleA)bean);
        }

        return bean;
    }
}
