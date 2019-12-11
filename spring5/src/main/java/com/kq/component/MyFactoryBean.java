package com.kq.component;

import com.kq.service.IFactoryBeanService;
import com.kq.service.impl.FactoryBeanServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * MyFactoryBean
 *
 * @author kq
 * @date 2019-12-11
 */

@Component
public class MyFactoryBean  implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        System.out.println("MyFactoryBean call");
        //这个Bean是我们自己new的，这里我们就可以控制Bean的创建过程了
        return new FactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return IFactoryBeanService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
