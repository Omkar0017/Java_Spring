package com.omkar.learnspringframework.helloWorld;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02SpringHelloWorld {

  public static void main(String[] args) {

try(
    //1: Launch Spring Context

    var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    //2.Configure the things that we want Spring to manage - @Configuration
    //HelloWorldConfiguration - @Configuration
    //name -@Bean

){   //Retrieving Information
  System.out.println("Name------->"+context.getBean("name"));
  System.out.println("Age------->"+context.getBean("age"));
  System.out.println("Age with type------->"+context.getBean(int.class));
  System.out.println("New Person--------->"+context.getBean("getPerson"));
  System.out.println("Address------------>"+context.getBean("address2"));
  System.out.println("New Person by Method---------->"+context.getBean("person2MethosCall"));
  System.out.println("New Person by Parameter"+context.getBean("person3Parameter"));
  System.out.println("New Person by using Primary---------->"+context.getBean(Person.class));
  System.out.println("New Person by using Qualifier-------->"+context.getBean(("person5Qualifier")));

  //List All Beans managed by Spring FrameWork
  Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);}
  }
}
