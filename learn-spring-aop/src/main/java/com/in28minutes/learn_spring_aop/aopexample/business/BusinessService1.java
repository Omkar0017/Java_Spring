package com.in28minutes.learn_spring_aop.aopexample.business;

import com.in28minutes.learn_spring_aop.aopexample.annotations.TrackTime;
import com.in28minutes.learn_spring_aop.aopexample.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;

    @TrackTime
    public int calculateMAx() throws InterruptedException {
        int[] data = dataService1.retriveData();

//        throw new RuntimeException("Something happened");
        return Arrays.stream(data).max().orElse(0);
    }
}
