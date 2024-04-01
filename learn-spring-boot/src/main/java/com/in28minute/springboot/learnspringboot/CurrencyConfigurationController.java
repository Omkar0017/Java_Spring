package com.in28minute.springboot.learnspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

  @Autowired
  CurrencyServceConfiguration configuration;

  @RequestMapping("/currency")
  public CurrencyServceConfiguration retrieveAllCourses(){
    System.out.println("Inside retrieveCourses method");
    return configuration;
  }
}
