package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import javax.lang.model.element.VariableElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {


  @GetMapping(path = "hello-world")
  public String helloWorld(){
    log.info("Inside Hello world");
    return "Hello World";

  }

  @GetMapping(path = "hello-world-bean")
  public HelloWorldBean helloWorldBean(){
    return new HelloWorldBean("Hello world bean!!");
  }


  @GetMapping(path = "hello-world-bean/path-variable/{name}")
  public HelloWorldBean helloWorldpathvariable(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello world to , %s",name));
  }
}
