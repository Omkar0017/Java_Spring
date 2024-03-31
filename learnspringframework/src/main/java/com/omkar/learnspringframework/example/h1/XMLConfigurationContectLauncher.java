package com.omkar.learnspringframework.example.h1;


import com.omkar.learnspringframework.game.GameRunner;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XMLConfigurationContectLauncher {


  public static void main(String[] args) {

    try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

      System.out.println(context.getBean("name"));
      System.out.println(context.getBean("age"));

  context.getBean(GameRunner.class).run();

    }
  }
}
