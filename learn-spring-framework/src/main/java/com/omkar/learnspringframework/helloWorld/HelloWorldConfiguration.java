package com.omkar.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name,int age,Address address){};
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
    var person = new Person("Srushti",24,new Address("Shelbourne Village","Dublin 2"));

    return person;
  }



  @Bean(name = "address2")
  public Address getAddress(){
    return  new Address("Grand canal docs","Dublin");
  }

  @Bean
  public Person person2MethosCall(){
    return new Person(name(),age(),getAddress());
  }

  @Bean
  public Person person3Parameter(String name, int age,Address address2){
    return new Person(name,age,address2);
  }

  @Bean(name = "address3")
  @Primary
  public Address address3(){
    return  new Address("Talbot Street ","Dublin 1");
  }

  @Bean
  @Primary
  public Person person4Parameter(String name, int age, Address address){
    return new Person(name,age,address);
  }

  @Bean(name = "address5")
  @Qualifier("address5qualifier")
  public Address address5() {
    return new Address("Motinagar", "Hyderabad");
  }

  @Bean
  public Person person5Qualifier(String name, int age, @Qualifier("address5qualifier") Address address) {
    //name,age,address2
    return new Person(name, age, address); //name, age
  }
}
