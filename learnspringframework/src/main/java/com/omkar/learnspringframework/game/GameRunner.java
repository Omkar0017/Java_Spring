package com.omkar.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
  //MarioGame game;
  private GameConsole game;
  public GameRunner(GameConsole game){
    this.game = game;
  }

  public void run(){
    System.out.println("Running Game :--->"+game.getClass().getSimpleName());
    game.up();
    game.down();
    game.left();
    game.right();

  }

}
