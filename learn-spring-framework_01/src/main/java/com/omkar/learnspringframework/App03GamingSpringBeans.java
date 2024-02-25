package com.omkar.learnspringframework;

import com.omkar.learnspringframework.game.GameConsole;
import com.omkar.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans  {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

    context.getBean(GameConsole.class).up();
    context.getBean(GameRunner.class).run();
  }

}
