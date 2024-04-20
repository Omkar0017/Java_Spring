package com.in28minutes.spring.myfirstwebapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList<>();
  static  int todoCount = 0;
  static {
    todos.add(new Todo(++todoCount,"Omkar","Learn Python", LocalDate.now().minusMonths(1),true));
    todos.add(new Todo(++todoCount,"Omkar","Learn Angular", LocalDate.now().plusMonths(2),false));
    todos.add(new Todo(++todoCount,"Omkar","Learn React", LocalDate.now().plusMonths(4),false));
    todos.add(new Todo(++todoCount,"Omkar","Learn AWS", LocalDate.now().plusMonths(6),false));
  }

  public List<Todo> findByUsername(String username){
    Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
    return todos.stream().filter(predicate).toList();
  }

  public void addTodo(String username, String description, LocalDate targetDate, boolean done){
    Todo todo = new Todo(++todoCount,username,description,targetDate,done);
    todos.add(todo);

  }

public  void deleteById(int id){
  Predicate<? super Todo> predicate = todo -> todo.getId() == id;
  todos.removeIf(predicate);
}

  public  Todo findById(int id){
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    return  todos.stream().filter(predicate).findFirst().get();
  }

  public void updateTodo(@Valid Todo todo){
    deleteById(todo.getId());
    todos.add(todo);

  }



}
