package com.in28minutes.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retriveData() throws InterruptedException {
        Thread.sleep(10);
        return new int[]{11,22,33,44,55,66};
    }
}
