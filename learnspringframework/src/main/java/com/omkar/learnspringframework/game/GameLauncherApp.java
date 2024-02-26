package com.omkar.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@ComponentScan("com.omkar.learnspringframework.game")
public class GameLauncherApp  {


  @Bean
  public GameRunner gameRunner(@Qualifier("SuperContraGameQualifier") GameConsole game){
    System.out.println("Parameter Game------->"+game);
    var gamerunner = new GameRunner(game);
    return gamerunner;
  }


  @Bean
  @Primary
  public GameRunner newGameRunner(GameConsole game){
    System.out.println("Inside NewGameRunner");
    System.out.println("Parameter Game------->"+game);
    var gamerunner = new GameRunner(game);
    return gamerunner;
  }
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(GameLauncherApp.class);

    context.getBean(GameConsole.class).up();
    context.getBean(GameRunner.class).run();


  }

}
