package com.kq.springdebug.simple.service.impl;

import com.kq.springdebug.simple.service.ICircleC;
import org.springframework.stereotype.Service;

@Service
public class CircleC implements ICircleC {

    @Override
    public void show() {
        System.out.println("c.show");
    }

    @Override
    public void showC() {
        System.out.println("c.showC");
    }


}
