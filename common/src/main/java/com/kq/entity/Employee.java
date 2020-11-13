package com.kq.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author kq
 * @date 2020-11-11 11:04
 * @since 2020-0630
 */
@Data
public class Employee {

    private Long id;
    private Date birythDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;



}
