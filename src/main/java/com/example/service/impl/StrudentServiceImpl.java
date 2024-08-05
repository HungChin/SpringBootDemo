package com.example.service.impl;

import com.example.data.dao.StudentDao;
import com.example.data.dto.StudentDto;
import com.example.data.entity.StudentEntity;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentDto getStudentById(int id) {
        StudentEntity student = studentDao.findStudentById(id);
        return new StudentDto(student);
    }
}
