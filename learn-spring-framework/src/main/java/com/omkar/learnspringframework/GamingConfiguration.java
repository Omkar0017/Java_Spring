package com.omkar.learnspringframework;


import com.omkar.learnspringframework.game.GameConsole;
import com.omkar.learnspringframework.game.GameRunner;
import com.omkar.learnspringframework.game.PacMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

  @Bean
  public GameConsole game(){
    var game = new PacMan();
    return game;
  }

  @Bean
  public GameRunner gameRunner(GameConsole game){
    var gamerunner = new GameRunner(game);
    return gamerunner;
  }
}
