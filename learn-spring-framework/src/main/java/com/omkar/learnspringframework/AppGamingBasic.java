package com.omkar.learnspringframework;

import com.omkar.learnspringframework.game.GameRunner;
import com.omkar.learnspringframework.game.MarioGame;
import com.omkar.learnspringframework.game.PacMan;
import com.omkar.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {

  public static void main(String[] args) {
    //var game = new MarioGame();
    //var game = new SuperContraGame();
    var game = new PacMan();
    var gameRunner = new GameRunner(game);

    gameRunner.run();
  }
}
