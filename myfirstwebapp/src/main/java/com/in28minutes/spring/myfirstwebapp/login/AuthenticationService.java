package com.in28minutes.spring.myfirstwebapp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


  public boolean authentication(String username, String password){

    boolean isvalidName = username.equalsIgnoreCase("Omkar");
    boolean isvalidPassword = password.equals("Password");

    return isvalidName && isvalidPassword;

  }
}
