package com.example.controller;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/school")
@Controller
public class ClassRoomController {
    private static final Logger Log = LoggerFactory.getLogger(ClassRoomController.class);
    public ClassRoomController() {
        Log.info("ClassRoomController啟動");
    }

    @Value("${schoolAcount}")
    private String schoolAcount;

    @Value("${schoolAddress:新北市}")
    private String schoolAddress;

    @Setter
    private String schoolName;

    @PostConstruct
    private void getSchoolAcount() {
        setSchoolName("淡江大學");
    }

    @ResponseBody
    @GetMapping("/classRoom")
    private String findAllClassRoom(){
       Log.info("{}學校帳號登入", schoolAcount);
        return "schoolAcount呼叫回傳所有教室資料";
    }

}
