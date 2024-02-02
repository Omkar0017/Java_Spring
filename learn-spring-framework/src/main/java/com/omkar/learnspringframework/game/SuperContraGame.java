package com.omkar.learnspringframework.game;

public class SuperContraGame implements GameConsole{

  public void up(){
    System.out.println("Up");
  }

  public void down(){
    System.out.println("Duck");
  }

  public void left(){
    System.out.println("Go Back");
  }

  public void right(){
    System.out.println("Fire");
  }
}
