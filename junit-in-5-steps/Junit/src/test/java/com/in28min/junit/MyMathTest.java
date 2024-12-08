package com.in28min.junit;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MyMathTest {


    @Test
    public void calculateSumTest(){
        MyMath myMath = new MyMath();
        int[] number1 = {1,3,5,7};
        int result = myMath.calculateSum(number1);
        int expected = 16;
        assertEquals(expected,result);

        int[] number2 = {1,2,3};
        assertNotSame(10,myMath.calculateSum(number2));
    }

    @Test
    public void calculateSum_emptyArray(){
        MyMath myMath = new MyMath();
        int[] number = {} ;
        int result = myMath.calculateSum(number);
        int expexted = 0;

        assertEquals(expexted,result);

    }


}
