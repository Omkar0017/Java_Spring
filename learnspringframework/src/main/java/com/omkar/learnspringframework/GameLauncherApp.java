package com.omkar.learnspringframework;

import com.omkar.learnspringframework.game.GameConsole;
import com.omkar.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;






@Configuration
@ComponentScan("com.omkar.learnspringframework.game")
public class GameLauncherApp  {


  @Bean
  public GameRunner gameRunner(GameConsole game){
    System.out.println("Parameter Game------->"+game);
    var gamerunner = new GameRunner(game);
    return gamerunner;
  }

  public static void main(String[] args) {

    System.out.println("Omkar");

    var context = new AnnotationConfigApplicationContext(GameLauncherApp.class);

    context.getBean(GameConsole.class).up();
    context.getBean(GameRunner.class).run();
  }

}
