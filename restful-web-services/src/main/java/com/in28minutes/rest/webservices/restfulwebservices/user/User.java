package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import lombok.Data;

@Data
public class User {

  private Integer id;
  private String name;
  private LocalDate birthDate;

  public User(Integer id, String name, LocalDate birthDate) {

    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }
}
