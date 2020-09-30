package com.kq.beandefinition.register.config;

import com.kq.entity.Inventory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2020-09-30 8:39
 * @since 2020-0630
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Inventory.class);
        AbstractBeanDefinition abstractBeanDefinition = beanDefinitionBuilder.getBeanDefinition();
        abstractBeanDefinition.getPropertyValues().addPropertyValue("code","1010");

        registry.registerBeanDefinition("inventory",abstractBeanDefinition);


    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("=======MyBeanDefinitionRegistryPostProcessor========");
    }

}
