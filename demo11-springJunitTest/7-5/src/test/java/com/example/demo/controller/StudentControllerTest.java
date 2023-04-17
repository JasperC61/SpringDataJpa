package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
 public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void getById() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/student/{studentId}",3)
                .header("headerName","headerValue")
                .queryParam("graduate","true");

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id",equalTo(3)))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andReturn();

        String body=mvcResult.getResponse().getContentAsString();
        System.out.println("return response body is"+body);

    }

    @Test
    public void create() throws Exception {
        RequestBuilder requestBuilder=MockMvcRequestBuilders
                .post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \n" +
                        "   \"name\":\"Bill\",\n" +
                        "   \"score\":55.5,\n" +
                        "   \"graduate\":false\n" +
                        "  \n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));


    }
}