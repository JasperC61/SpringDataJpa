package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private  StudentRepository studentRepository;

    @PostMapping("/student")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);
        return "執行資料庫 create操作";
    }

    @PutMapping("/student/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
       Student s= studentRepository.findById(studentId).orElse(null);
//        student.setId(studentId);
//        studentRepository.save(student);
        if(s!=null){
            s.setName(student.getName());
            studentRepository.save(s);
            return "執行資料庫 update操作";
        }else{
            return "update fail , data no exist";
        }

    }


    @DeleteMapping("/student/{studentId}")
    public  String delete(@PathVariable Integer studentId){
        studentRepository.deleteById(studentId);
        return "執行資料庫 delete操作";
    }

    @GetMapping("/student/{studentId}")
    public Student read(@PathVariable Integer studentId){

        Student student=studentRepository.findById(studentId).orElse(null);
        return student;
    }
}
