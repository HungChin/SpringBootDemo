package com.example.data.dao.impl;

import com.example.data.dao.StudentDao;
import com.example.data.entity.StudentEntity;
import com.example.data.rowmapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public StudentEntity findStudentById(int Id) {
        String sql = "select * from student where id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", Id);
        List<StudentEntity> studentEntityList = jdbcTemplate.query(sql, params, new StudentRowMapper());
        if (!CollectionUtils.isEmpty(studentEntityList)) {
            return studentEntityList.getFirst();
        }
        return null;
    }
}
