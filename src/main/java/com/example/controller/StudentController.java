package com.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/school",method =  RequestMethod.GET)
@RestController
public class StudentController {
    private final static Logger Log= LoggerFactory.getLogger(StudentController.class);
    public StudentController() {
        Log.info("啟動StudentController");
    }
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable("id")String id,@RequestParam(value = "name",required = false)String name){
        Log.info("執行getStudent取得學生姓名{}及Id為{}的資料",name,id);
        return "取得Id成功";
    }
}
