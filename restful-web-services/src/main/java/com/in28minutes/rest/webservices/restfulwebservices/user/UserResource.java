package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserResource {

  @Autowired
  private UserDAOService userDAOService;

  @GetMapping("/users")
  public List<User> retrivellUser(){
  log.info("<---------retrivellUser start--------->");
  List<User> users = userDAOService.findAll();
  return  users;
  }

  @GetMapping("/user/{id}")
  public User retriveUser(@PathVariable int id){
    log.info("<---------retriveUser start--------->");
    User user = userDAOService.findUser(id);
    return user;
  }

  @PostMapping("/users")
  public boolean createUser(@RequestBody User user){
    log.info("<---------createUser start--------->");
    //User user = new User(5,"Sanket", LocalDate.now().minusYears(29));
    return userDAOService.save(user);
  }
}
