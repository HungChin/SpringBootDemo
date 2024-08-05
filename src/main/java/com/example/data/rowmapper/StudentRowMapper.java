package com.example.data.rowmapper;

import com.example.data.entity.StudentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentRowMapper implements RowMapper<StudentEntity> {
    @Override
    public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(rs.getInt("id"));
        studentEntity.setName(rs.getString("name"));
        studentEntity.setAge(rs.getInt("age"));
        studentEntity.setGender(rs.getString("gender"));
        studentEntity.setCreateDate(rs.getDate("create_date"));
        return studentEntity;
    }
}
