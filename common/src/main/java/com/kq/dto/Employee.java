package com.kq.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 注解在类上；提供类所有属性的 getting 和 setting 方法，
 * 此外还提供了equals、canEqual、hashCode、toString 方法
 */
@Data
public class Employee {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    private String number;

}
