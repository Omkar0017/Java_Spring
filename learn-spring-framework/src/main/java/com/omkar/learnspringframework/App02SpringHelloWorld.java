package com.omkar.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02SpringHelloWorld {

  public static void main(String[] args) {


    //1: Launch Spring Context

    var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    //2.Configure the things that we want Spring to manage - @Configuration
    //HelloWorldConfiguration - @Configuration
    //name -@Bean

    //Retrieving Information
    System.out.println("Name------->"+context.getBean("name"));
    System.out.println("Age------->"+context.getBean("age"));
    System.out.println("Age with type------->"+context.getBean(int.class));
    System.out.println("New Person--------->"+context.getBean("getPerson"));
    System.out.println("Address------------>"+context.getBean("getAddress"));
    System.out.println("New Person---------->"+context.getBean("person2MethosCall"));


  }
}
