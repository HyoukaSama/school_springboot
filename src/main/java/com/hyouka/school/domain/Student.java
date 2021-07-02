package com.hyouka.school.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "student")
public class Student {
    @Id
    private Integer id;

    private String name;

    private String grade;

    public Student() {
        System.out.println("student...constructor");


    }

    public void init() {
        System.out.println("student  init-------------");
    }


    public void destory() {
        System.out.println("student  destory-------------");
    }
}
