package com.in28minutes.spring.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList<>();
  static {
    todos.add(new Todo(1,"Omkar","Learn Python", LocalDate.now().minusMonths(1),true));
    todos.add(new Todo(1,"Omkar","Learn Angular", LocalDate.now().plusMonths(2),false));
    todos.add(new Todo(1,"Omkar","Learn React", LocalDate.now().plusMonths(4),false));
    todos.add(new Todo(1,"Omkar","Learn AWS", LocalDate.now().plusMonths(6),false));
  }

  public List<Todo> findByUsername(String username){
    return  todos;
  }
}
