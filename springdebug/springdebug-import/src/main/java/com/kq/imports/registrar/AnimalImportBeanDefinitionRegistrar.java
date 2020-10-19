package com.kq.imports.registrar;

import com.kq.imports.beanfactoryprocessor.MyMapperScannerConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author kq
 * @date 2020-10-19 13:55
 * @since 2020-0630
 */
public class AnimalImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyMapperScannerConfigurer.class);

        registry.registerBeanDefinition("animalImportBeanDefinitionRegistrar", builder.getBeanDefinition());
    }
}
