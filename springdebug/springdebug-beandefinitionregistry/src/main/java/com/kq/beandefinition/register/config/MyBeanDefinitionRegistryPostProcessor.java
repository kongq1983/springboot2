package com.kq.beandefinition.register.config;

import com.kq.entity.Inventory;
import com.kq.entity.School;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
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

        // BeanDefinitionRegistry注册
        registry.registerBeanDefinition("inventory",abstractBeanDefinition);

        // BeanDefinitionReaderUtils 通过工具栏注册，上面那句话其实也调用，多做一些alias

        BeanDefinitionBuilder schoolBeanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(School.class);
        AbstractBeanDefinition schoolAbstractBeanDefinition = schoolBeanDefinitionBuilder.getBeanDefinition();
        schoolAbstractBeanDefinition.getPropertyValues().addPropertyValue("name","admin");

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(schoolBeanDefinitionBuilder.getBeanDefinition(), "school",new String[]{"firstSchool,secondSchool"});

        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder,registry);



    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("=======MyBeanDefinitionRegistryPostProcessor========");
    }

}
