package com.omkar.learnspringframework.example.a0.a1;


import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContectLauncher {


  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(SimpleSpringContectLauncher.class)) {

      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
  }
}
