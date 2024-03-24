package com.omkar.learnspringframework.example.e1;

import com.omkar.learnspringframework.example.a0.a1.SimpleSpringContectLauncher;
import java.util.Arrays;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class NormalClass{}


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}

@ComponentScan
@Configuration
public class BeanScopeLauncherApplication {

  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)) {

      System.out.println(context.getBean(NormalClass.class));
      System.out.println(context.getBean(NormalClass.class));


      System.out.println(context.getBean(PrototypeClass.class));
      System.out.println(context.getBean(PrototypeClass.class));
      System.out.println(context.getBean(PrototypeClass.class));
    }
  }
}
