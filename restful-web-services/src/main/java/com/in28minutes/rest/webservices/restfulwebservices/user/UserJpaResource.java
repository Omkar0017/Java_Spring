package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.in28minutes.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
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
public class UserJpaResource {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PostRepository postRepository;

  @Autowired
  private UserDAOService userDAOService;

  @GetMapping("/jpa/users")
  public List<User> retriveallUser(){
  log.info("<---------retriveallUser start--------->");
  List<User> users = userRepository.findAll();
  return  users;
  }

  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> retriveUser(@PathVariable int id){
    log.info("<---------retriveUser start--------->");
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()){
      throw new UserNotFoundException("id: "+id);
    }

    EntityModel<User> entityModel = EntityModel.of(user.get());
    WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retriveallUser());
    entityModel.add(link.withRel("all-users"));

    return entityModel;
  }


  @DeleteMapping("/jpa/users/{id}")
  public void deletebyId(@PathVariable int id){
    log.info("<----------Delete by Id started---------->");
    userRepository.deleteById(id);

  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> retrivePostForUser(@PathVariable int id){
    log.info("<---------retrrivePostForUser start--------->");
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()){
      throw new UserNotFoundException("id: "+id);
    }
    return  user.get().getPosts();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<User> createPostForUser(@PathVariable int id,@RequestBody  @Valid Post post){
    log.info("<---------createPostForUser start--------->");
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()){
      throw new UserNotFoundException("id: "+id);
    }
    post.setUser(user.get());
    Post savedPost = postRepository.save(post);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();

    return ResponseEntity.created(location).build();

  }


  @PostMapping("/jpa/users")
  public ResponseEntity<User> createUser(@RequestBody  @Valid User user){
    log.info("<---------createUser start--------->");
    //User user = new User(5,"Sanket", LocalDate.now().minusYears(29));
     User savedUser = userRepository.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }
}
