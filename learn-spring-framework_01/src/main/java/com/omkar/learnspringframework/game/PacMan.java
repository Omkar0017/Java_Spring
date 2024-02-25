package com.omkar.learnspringframework.game;

public class PacMan implements GameConsole{

  @Override
  public void up() {
    System.out.println("Up");
  }

  @Override
  public void down() {
    System.out.println("Dowm");
  }

  @Override
  public void left() {
    System.out.println("Left");

  }

  @Override
  public void right() {
    System.out.println("Right");
  }
}
