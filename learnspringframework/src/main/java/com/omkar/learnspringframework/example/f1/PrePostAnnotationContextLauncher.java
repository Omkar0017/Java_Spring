package com.omkar.learnspringframework.example.f1;

import com.omkar.learnspringframework.example.a0.a1.SimpleSpringContectLauncher;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class SomeClass{
  private  SomeDependancy someDependancy;

  public  SomeClass(SomeDependancy someDependancy){
    super();
    this.someDependancy = someDependancy;
    System.out.println("Done with all Dependencies");
  }


  @PostConstruct
  public void initialize(){
    this.someDependancy.getReady();
  }

  @PreDestroy
  public void cleanUp(){
    System.out.println("Executing before Bean is destroyed");
  }

}

@Component
class SomeDependancy{

  public void getReady() {
    System.out.println("Some Logic to run after initialization of bean before putting it into service");
  }
}

@ComponentScan
@Configuration
public class PrePostAnnotationContextLauncher {


  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncher.class)) {

      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
  }
}
