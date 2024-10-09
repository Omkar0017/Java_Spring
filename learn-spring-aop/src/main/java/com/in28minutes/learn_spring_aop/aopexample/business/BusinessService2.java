package com.in28minutes.learn_spring_aop.aopexample.business;

import com.in28minutes.learn_spring_aop.aopexample.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    @Autowired
    private DataService2 dataService2;

    public int calculateMin() throws InterruptedException {
        int[] data = dataService2.retriveData();

//        throw new RuntimeException("Something happened");
        return Arrays.stream(data).min().orElse(0);
    }
}
