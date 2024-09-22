package com.in28minutes.rest.webservices.restfulwebservices.user;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

  private static int userCount = 0;

  private static List<User> users = new ArrayList<>();

  static {
    users.add(new User(++userCount,"omkar", LocalDate.now().minusYears(25)));
    users.add(new User(++userCount,"Srushti", LocalDate.now().minusYears(25)));
    users.add(new User(++userCount,"Dnyanesh", LocalDate.now().minusYears(30)));
    users.add(new User(++userCount,"Chinmay", LocalDate.now().minusYears(27)));
  }

  public List<User> findAll(){
    return users;
  }

  public User findUser(int id){
    Predicate<? super User> predicate = user -> user.getId() == id;
    return  users.stream().filter(predicate).findFirst().orElse(null);

  }

  public void deleteById(int id){
    Predicate<? super User> predicate = user -> user.getId() == id;
    users.removeIf(predicate);
  }

  public User save(User user){
    user.setId(++userCount);
    users.add(user);
    return user;
  }

}
