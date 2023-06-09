package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("Mary");

        model.addAttribute("myStudent", student);

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName,
                        String userPassword) {

        System.out.println("userName is: " + userName);
        System.out.println("userPassword is: " + userPassword);

        return "login";
    }
}