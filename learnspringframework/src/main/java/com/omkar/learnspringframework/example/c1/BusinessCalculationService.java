package com.omkar.learnspringframework.example.c1;


import java.util.Arrays;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {


  DataService dataService;

  BusinessCalculationService(DataService dataService){
    super();
    this.dataService = dataService;
  }

  public int findMax() {
    return Arrays.stream(dataService.retriveData()).max().orElse(0);
  }


}
