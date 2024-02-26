package com.omkar.learnspringframework.example.a1;


import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class DepInjectionLauncherApp {


  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApp.class)) {

      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

      System.out.println(context.getBean((Bussiness.class)));
    }
  }
}


//To test different types of Dependency Injection

@Component
class Bussiness {

  @Autowired
  Dependency1 dependency1;
  @Autowired
  Dependency2 dependency2;

  public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("Using ");
    sb.append(dependency1.getClass().toString());
    sb.append(" And ");
    sb.append(dependency2.getClass().toString());

    return sb.toString();
  }
}

@Component
class Dependency1{}

@Component
class Dependency2{}