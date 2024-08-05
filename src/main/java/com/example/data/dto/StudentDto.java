package com.example.data.dto;

import com.example.data.entity.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    public StudentDto(StudentEntity studentEntity) {
        setId(studentEntity.getId());
        setName(studentEntity.getName());
        setAge(studentEntity.getAge());
        setGender(studentEntity.getGender());
        setCreateDate(studentEntity.getCreateDate());
    }
    private int id;
    private String name;
    private int age;
    private String gender;
    private Date createDate;
}
