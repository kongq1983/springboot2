package com.kq.bfp.beanfactoryprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-09-29 10:07
 * @since 2020-0630
 */

@Component
public class ABeanFactoryProcess implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ABeanFactoryProcess.postProcessBeanFactory:"+beanFactory);
    }
}
