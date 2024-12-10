package com.in28min.junit;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MyMathTest {

    private  MyMath myMath = new MyMath();

    @Test
    public void calculateSumTest(){

        assertEquals(16,myMath.calculateSum(new int[]{1,3,5,7}));
        assertNotSame(10,myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    public void calculateSum_emptyArray(){

        assertEquals(0,myMath.calculateSum(new int[]{}));

    }


}
