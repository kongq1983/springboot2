package com.kq.bfp.beanfactoryprocess.ordered;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-09-29 10:12
 * @since 2020-0630
 */
@Component
public class BeanFactoryProcessOrderA implements BeanFactoryPostProcessor , Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("order="+this.getOrder()+" BeanFactoryProcessOrderA.postProcessBeanFactory:"+beanFactory+" order="+this.getOrder());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}