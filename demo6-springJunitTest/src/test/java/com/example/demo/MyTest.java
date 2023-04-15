package com.example.demo;

import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeEach
    public  void beforeEach(){
        System.out.println("execute @BeforeEach");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("execute @AfterEach");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("execute @BeforeAll");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("execute @AfterAll");
    }
    @Test
    public void t1(){
        System.out.println("execute t1");
    }
    @Test
    public void t2(){
        System.out.println("execute t2");
    }
}
