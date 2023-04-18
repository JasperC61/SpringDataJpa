package com.example.json.resttemplate;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public  String getForObject(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();
       Student student= restTemplate.getForObject(
               //"https://mocki.io/v1/0bd13a70-020e-47b6-b695-ab9b8cc899a0",
               "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",

        Student.class);

        System.out.println("Student id is :"+student.getId());
        System.out.println("Student name is :"+student.getName());
        System.out.println("Student phone is :"+student.contactPhone);
        return "getForObject success";
    }

    @GetMapping
    public  String getForObjectWithParam(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();

        Map<String , Objects> queryParamMap=new HashMap<>();
        queryParamMap.put("graduate",true);
        Student student=restTemplate.getForObject(
                "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",
                Student.class,
            queryParamMap);
        return "getForObject with param success";


    }
  @GetMapping("/getForEntity")
    public  String getForEntity(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<Student> studentEntity=restTemplate.getForEntity(
                "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",
                Student.class
        );

        System.out.println("http狀態碼: "+studentEntity.getStatusCode());
        Student student=studentEntity.getBody();
        System.out.println("Student id is :"+student.getId());
        System.out.println("Student name is :"+student.getName());
        System.out.println("Student phone is :"+student.contactPhone);
        return "getEntity success";
    }

    @GetMapping("/postForObject")
    public String postForObject(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();
        Student studentRequestBody=new Student();
        studentRequestBody.setName("John");

        Student rs=restTemplate.postForObject(
                "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",
                studentRequestBody,
                Student.class
        );
        return "postForObject success";

    }
    @GetMapping("/postForEntity")
    public String postForEntity(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();
        Student studentRequestBody=new Student();
        studentRequestBody.setName("John");

        ResponseEntity<Student> responseEntity=restTemplate.postForEntity(
                "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",
                studentRequestBody,
                Student.class
        );
        return "postForEntity success";
    }
  @GetMapping("/exchange")
    public  String exchang(){
        //請求外部API並把她轉換成Java Object(mocki)
        RestTemplate restTemplate=new RestTemplate();
        //使用exchang 發起Get請求
        HttpHeaders requestHeaders=new HttpHeaders();
        requestHeaders.set("header1","123");
        HttpEntity requestEntity=new HttpEntity(requestHeaders);
        Map<String,Objects> queryParamMap=new HashMap<>();
        queryParamMap.put("graduate",true)
        HttpEntity<Student> getStudentEntity=restTemplate.exchange(
                "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36",
                HttpMethod.GET,
                requestEntity,
                Student.class,
                queryParamMap

        );

      //使用exchang 發起Get請求
      HttpHeaders requestHeaders2=new HttpHeaders();
      requestHeaders2.set("header2","456");
      requestHeaders2.setContentType(MediaType.APPLICATION_JSON);

      Student studentRequestBody=new Student();
      studentRequestBody.setName("John");
      HttpEntity requestEntity2=new HttpEntity(studentRequestBody,requestHeaders2);
      ResponseEntity<Student> postStudentEntity=restTemplate.exchange(
              "https://mocki.io/v1/28eb3236-0f9e-4860-93a1-f19001f33e36" ,
              HttpMethod.POST,
              requestEntity2,
              Student.class
      );
      return "exchange success";
    }





}
