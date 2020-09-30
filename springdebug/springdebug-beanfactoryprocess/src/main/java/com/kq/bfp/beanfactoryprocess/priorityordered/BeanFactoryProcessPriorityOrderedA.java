package com.kq.bfp.beanfactoryprocess.priorityordered;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-09-29 10:19
 * @since 2020-0630
 */
@Component
public class BeanFactoryProcessPriorityOrderedA implements BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("order="+this.getOrder()+" BeanFactoryProcessPriorityOrderedA.postProcessBeanFactory:"+beanFactory+" order="+this.getOrder());
    }

    @Override
    public int getOrder() {
        return 2;
    }
}