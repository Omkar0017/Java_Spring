package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
@Entity(name = "user_details")
public class User {

  protected User() {

  }

  @Id
  @GeneratedValue
  private Integer id;

  @Size(min = 2, message = "Name should have atleast 2 characters")
  @JsonProperty("UserName")
  private String name;

  @Past(message = "Birthdate cannot be future date")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Post> posts;

  public User(Integer id, String name, LocalDate birthDate) {

    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }
}
