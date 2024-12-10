package com.in28min.junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class MyAsserTest {

    List<String> todos = Arrays.asList("AWS", "AZURE", "DevOps");

    @Test
    public void testAssert(){
        boolean test1 = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");

        assertTrue(test1);
        assertFalse(test2);

        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
        assertEquals(3,todos.size());

    }

}
