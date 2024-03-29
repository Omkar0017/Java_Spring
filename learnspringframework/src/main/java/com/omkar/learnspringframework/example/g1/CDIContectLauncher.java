package com.omkar.learnspringframework.example.g1;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//@Component
@Named
class BusinessService{
  private DataService dataService;

  public DataService getDataService() {
    System.out.println("Getting DataService Bean");
    return dataService;
  }

  //@Autowired
  @Inject
  public void setDataService(DataService dataService) {
    System.out.println("Setter Operation Performed");
    this.dataService = dataService; 
  }
}


//@Component
@Named
class DataService{

}



@Configuration
@ComponentScan
public class CDIContectLauncher {


  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(CDIContectLauncher.class)) {

      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

      System.out.println(context.getBean(BusinessService.class).getDataService());
    }
  }
}
