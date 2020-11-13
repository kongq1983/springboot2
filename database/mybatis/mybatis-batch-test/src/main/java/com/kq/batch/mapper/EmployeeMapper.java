package com.kq.batch.mapper;

import com.kq.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kq
 * @date 2020-11-11 11:02
 * @since 2020-0630
 */
@Mapper
public interface EmployeeMapper {


    @Insert("insert into employee_1(emp_no,birth_date,first_name,last_name,gender,hire_date) values(#{id},#{birythDate},#{firstName},#{lastName},#{gender},#{hireDate})")
    public void insert(Employee employee);

    @Insert("insert into employee_1(birth_date,first_name,last_name,gender,hire_date) values(#{birythDate},#{firstName},#{lastName},#{gender},#{hireDate})")
    public void insertNoId(Employee employee);


}
