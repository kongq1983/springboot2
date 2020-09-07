package com.kq.resttemplate;

import com.kq.resttemplate.config.MyConpoment;
import com.kq.resttemplate.config.MyConpoment1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyConpomentTest extends BaseTest{

    @Autowired
    private MyConpoment myConpoment;
    @Autowired
    private MyConpoment1 myConpoment1;


    @Test
    public void testTimeout(){
        myConpoment1.execute();
        myConpoment.execute();
    }

}
