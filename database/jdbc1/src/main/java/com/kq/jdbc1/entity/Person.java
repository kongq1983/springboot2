package com.kq.jdbc1.entity;

import lombok.Data;

import java.util.Date;

/**
 * Account
 *
 * @author kq
 * @date 2019-10-11
 */
@Data
public class Person {

    private Long id;
    private String username;
    private String phone;
    private String province;
    private Date createTime;


}
