package com.in28minutes.rest.webservices.restfulwebservices.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

  @GetMapping("v1/person")
  public PersonV1 getFirstVersionOfPerson(){
    return new PersonV1("Omkar Patil");
  }

  @GetMapping("v2/person")
  public PersonV2 getSecondVersionOfPerson(){
    return new PersonV2(new Name("Omkar", "Patil"));
  }

  //http://localhost:8080/person?version=2
  @GetMapping(path = "person",params = "version=1")
  public PersonV1 getFirstVersionOfPersonRequestParam(){
    return new PersonV1("Omkar Patil");
  }


  @GetMapping(path = "person",params = "version=2")
  public PersonV2 getSecondVersionOfPersonRequestParam(){
    return new PersonV2(new Name("Omkar", "Patil"));
  }

  //http://localhost:8080/person/header header = X-API-VERSION =1
  @GetMapping(path = "person/header",headers = "X-API-VERSION=1")
  public PersonV1 getFirstVersionOfPersonRequestHeader(){
    return new PersonV1("Omkar Patil");
  }


  @GetMapping(path = "person/header",headers = "X-API-VERSION=2")
  public PersonV2 getSecondVersionOfPersonRequestHeader(){
    return new PersonV2(new Name("Omkar", "Patil"));
  }
}
