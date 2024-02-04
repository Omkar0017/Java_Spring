package com.omkar.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



record Person(String name,int age){};
record Address(String firstLine,String city){};
@Configuration
public class HelloWorldConfiguration {

  @Bean
  public String name(){
      return "Omkar";
    }

  @Bean
  public  int age(){
    return  25;
  }

  @Bean
  public Person getPerson(){
    var person = new Person("Srushti",24);

    return person;
  }

  @Bean
  public Address getAddress(){
    return  new Address("Grand canal docs","Dublin");
  }

  @Bean
  public Person person2MethosCall(){
    return new Person(name(),age());
  }

}
