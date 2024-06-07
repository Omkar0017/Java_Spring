package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Data
public class User {

  private Integer id;
  @Size(min = 2, message = "Name should have atleast 2 characters")
  private String name;
  @Past(message = "Birthdate cannot be future date")
  private LocalDate birthDate;

  public User(Integer id, String name, LocalDate birthDate) {

    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }
}
