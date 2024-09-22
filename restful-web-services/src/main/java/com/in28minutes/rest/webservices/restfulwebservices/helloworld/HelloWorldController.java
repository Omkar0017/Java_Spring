package com.in28minutes.rest.webservices.restfulwebservices.helloworld;



import jakarta.persistence.Access;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

  @Autowired
  MessageSource messageSource;

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

  @GetMapping(path = "hello-world-internationalized")
  public String helloWorldInternationalized(){
    log.info("Inside Hello world internationalized");

    Locale locale = LocaleContextHolder.getLocale();

    return messageSource.getMessage("good.morning.message",null,"default",locale);
//    return "Hello World v2";

  }
}
