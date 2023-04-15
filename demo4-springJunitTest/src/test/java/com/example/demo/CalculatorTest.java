package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
   public  void add(){
       Calculator calculator=new Calculator();
       int rs=calculator.add(1,2);
        assertNotNull(rs);
        assertEquals(3,rs);
      // assertEquals(3,rs," problem with add method ");
        assertTrue(rs>1);
   }

   @Test
   public  void divide(){

       Calculator calculator=new Calculator();
       //lambda express use ArithmeticException.class throws exception
       assertThrows(ArithmeticException.class,()->{
           int rs=calculator.divide(1,0);
       });

   }
}