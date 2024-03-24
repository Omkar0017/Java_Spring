package com.omkar.learnspringframework.example.d1;


import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class LazyIntializationApplicationLauncher {

  public static void main(String[] args) {

    try (var context =
        new AnnotationConfigApplicationContext
            (LazyIntializationApplicationLauncher.class)) {

      System.out.println("Finished Initialization");

      context.getBean(classB.class).doSomeThing();



    }
  }
}


@Component
@Lazy
class classB {
  classA a;

  classB(classA a){
    System.out.println("Initializing class A in class B");
    this.a = a;
  }

  public void doSomeThing(){
    System.out.println("Doing something");

  }
}


@Component
class classA{

}