package com.kq.springmvc.httpclient;

import com.kq.dto.Employee;
import com.kq.springmvc.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * EmployeeRestfulClientTest
 *
 * @author kq
 * @date 2019-08-09
 */
public class EmployeeRestfulClientTest extends BaseTest{

    @Autowired
    private EmployeeRestfulClient employeeRestfulClient;

    @Autowired
    private RestTemplate restTemplate;



    @Test
    public void testScheduled() {

        Employee e = new Employee();
        e.setId(1l);
        e.setAge(18);
        e.setName("king");
        e.setNumber("000001");

        employeeRestfulClient.employeeAdd(e);

    }

    @Test
    public void testEmployeeUpdate(){
        Employee e = new Employee();
        e.setId(10l);
        e.setAge(28);
        e.setName("king");
        e.setNumber("000001");
        employeeRestfulClient.employeeUpdate(e);
    }


}
