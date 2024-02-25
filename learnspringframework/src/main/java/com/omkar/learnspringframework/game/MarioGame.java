package com.omkar.learnspringframework.game;


import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GameConsole{

  public void up(){
    System.out.println("Jump");
  }

  public void down(){
    System.out.println("Go inside the hole");
  }

  public void left(){
    System.out.println("Go Back");
  }

  public void right(){
    System.out.println("Accelerate");
  }
}