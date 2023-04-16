package com.example.demo.dao;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentDaoImplTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void getById(){
        Student student=studentDao.getById(3);
        assertNotNull(student);
        assertEquals("Judy",student.getName());
        assertEquals(100,student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());

    }
    @Transactional
    @Test
    public  void deleteById(){
        studentDao.deleteById(3);
        Student student=studentDao.getById(3);
        assertNull(student);

    }
    @Test
    @Transactional
    public void insert(){
        Student student=new Student();
        student.setName("Kevin");
        student.setScore(66.2);
        student.setGraduate(true);

       Integer studentId=studentDao.insert(student);
       Student rs=studentDao.getById(studentId);
       assertNotNull(rs);
       assertEquals("Kevin",rs.getName());
       assertEquals(66.2,rs.getScore());
       assertTrue(rs.isGraduate());
       assertNotNull(rs.getCreateDate());

    }

    @Test
    @Transactional
    public  void update(){
        Student student=studentDao.getById(3);
        student.setName("John");
        studentDao.update(student);

        Student rs=studentDao.getById(3);
        assertNotNull(rs);
        assertEquals("John",rs.getName());
    }

}