package com.omkar.learnspringframework;

import com.omkar.learnspringframework.game.GameRunner;
import com.omkar.learnspringframework.game.MarioGame;
import com.omkar.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {

  public static void main(String[] args) {
    var marioGame = new MarioGame();
    var suoerContraGame = new SuperContraGame();
    var gameRunner = new GameRunner(suoerContraGame);

    gameRunner.run();
  }
}
