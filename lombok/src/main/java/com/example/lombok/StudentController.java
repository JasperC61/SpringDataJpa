package com.example.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/t1")
    public Student t1(){
        Student student=new Student();
        student.setId(1);
        student.setName("Mary");

        return  student;
    }
}
