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
//@AutoWired is type of field Injection

//For Setter based Injection Setters are generated
@Component
class Bussiness {


  Dependency1 dependency1;

  Dependency2 dependency2;

  
  public Bussiness(Dependency1 dependency1, Dependency2 dependency2) {
    System.out.println("COnstructor Injection---------- BusinessClass");
    this.dependency1 = dependency1;
    this.dependency2 = dependency2;
  }

  //  @Autowired
//  public void setDependency1(Dependency1 dependency1) {
//    System.out.println("*******dependency1***********");
//    this.dependency1 = dependency1;
//  }
//
//  @Autowired
//  public void setDependency2(Dependency2 dependency2) {
//    System.out.println("**********dependency2**********");
//    this.dependency2 = dependency2;
//  }

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