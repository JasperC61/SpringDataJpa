package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private  StudentRepository studentRepository;

    @PostMapping("/student")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);
        return "執行資料庫 create操作";
    }
}
