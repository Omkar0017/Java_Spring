package com.in28minutes.learn_spring_aop.aopexample.business;

import com.in28minutes.learn_spring_aop.aopexample.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;

    public int calculateMAx(){
        int[] data = dataService1.retriveData();

        return Arrays.stream(data).max().orElse(0);
    }
}
