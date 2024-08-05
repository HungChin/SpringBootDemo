package com.example.data.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentEntity {
    private int id;
    private String name;
    private int age;
    private String gender;
    private Date createDate;
}
