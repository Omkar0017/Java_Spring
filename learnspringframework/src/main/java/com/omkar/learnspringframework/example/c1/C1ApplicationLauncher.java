package com.omkar.learnspringframework.example.c1;


import java.util.Arrays;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan
public class C1ApplicationLauncher {

  public static void main(String[] args) {

    try (var context =
        new AnnotationConfigApplicationContext
            (C1ApplicationLauncher.class)) {

      Arrays.stream(context.getBeanDefinitionNames())
          .forEach(System.out::println);

      System.out.println("*********Invoking the method********");
      System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }
  }
}
