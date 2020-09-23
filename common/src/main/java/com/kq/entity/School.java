package com.kq.entity;

import lombok.Data;

/**
 * School
 *
 * @author kq
 * @date 2019-11-27
 */

@Data
public class School {

    private Long id;
    private String name;
    private Teacher teacher;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("School{");
//        sb.append("id=").append(id);
//        sb.append(", teacher=").append(teacher);
//        sb.append('}');
//        return sb.toString();
//    }
}
