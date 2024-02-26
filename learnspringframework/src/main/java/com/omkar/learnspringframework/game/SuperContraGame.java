package com.omkar.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
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
