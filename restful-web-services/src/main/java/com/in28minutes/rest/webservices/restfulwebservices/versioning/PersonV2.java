package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import lombok.Data;

@Data
public class PersonV2 {

  private Name name;

  public PersonV2(Name name) {
    this.name = name;
  }
}
