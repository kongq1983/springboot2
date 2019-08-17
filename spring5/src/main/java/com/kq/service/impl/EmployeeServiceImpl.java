package com.kq.service.impl;

import com.kq.dto.Employee;
import com.kq.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


    @Override
    public void add(Employee e) {
        System.out.printf("employee="+e);
    }

    @Override
    public String getName(String id) {
        return "king-"+id;
    }
}
