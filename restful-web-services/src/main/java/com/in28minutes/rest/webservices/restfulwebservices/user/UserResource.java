package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
public class UserResource {

  @Autowired
  private UserDAOService userDAOService;

  @GetMapping("/users")
  public List<User> retriveallUser(){
  log.info("<---------retriveallUser start--------->");
  List<User> users = userDAOService.findAll();
  return  users;
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> retriveUser(@PathVariable int id){
    log.info("<---------retriveUser start--------->");
    User user = userDAOService.findUser(id);
    if (user == null){
      throw new UserNotFoundException("id: "+id);
    }

    EntityModel<User> entityModel = EntityModel.of(user);
    WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retriveallUser());
    entityModel.add(link.withRel("all-users"));

    return entityModel;
  }


  @DeleteMapping("/users/{id}")
  public void deletebyId(@PathVariable int id){
    log.info("<----------Delete by Id started---------->");
    userDAOService.deleteById(id);

  }


  @PostMapping("/users")
  public ResponseEntity<User> createUser(@RequestBody  @Valid User user){
    log.info("<---------createUser start--------->");
    //User user = new User(5,"Sanket", LocalDate.now().minusYears(29));
     User savedUser = userDAOService.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }
}
