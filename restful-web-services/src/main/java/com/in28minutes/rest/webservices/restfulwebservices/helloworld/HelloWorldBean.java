package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import lombok.Data;

@Data
public class HelloWorldBean {
private String message;

  public HelloWorldBean(String message) {
    this.message = message;
  }
}
