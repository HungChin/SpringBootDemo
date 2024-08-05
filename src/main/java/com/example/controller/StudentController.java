package com.example.controller;
import com.example.data.dto.StudentDto;
import com.example.data.entity.StudentEntity;
import com.example.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/school",method =  RequestMethod.GET)
@RestController
public class StudentController {
    private final static Logger Log= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    public StudentController() {
        Log.info("啟動StudentController");
    }
//    @GetMapping("/student/{id}")
//    public String getStudent(@PathVariable("id")String id,@RequestParam(value = "name",required = false)String name){
//        Log.info("執行getStudent取得學生姓名{}及Id為{}的資料",name,id);
//        return "取得Id成功";
//    }

    @GetMapping("/student/{id}")
    private String getStudentById(@PathVariable("id") int id){
        ObjectMapper objectMapper = new ObjectMapper();
        Log.info("執行取得學生Id為{}的資料",id);
        StudentDto student = studentService.getStudentById(id);
        String studentJson = "";
        try {
             studentJson = objectMapper.writeValueAsString(student);
            Log.info("查詢學生Id資料結果:"+studentJson);
        }catch (JsonProcessingException jsonEx){
            Log.error("Object轉換json字串發生錯誤:"+ jsonEx.getMessage());
        }
        return studentJson;
    }
}
