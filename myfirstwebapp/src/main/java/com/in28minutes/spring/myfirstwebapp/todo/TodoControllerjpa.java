package com.in28minutes.spring.myfirstwebapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
@Slf4j
public class TodoControllerjpa {

  @Autowired
  TodoRepository todoRepository;


  @RequestMapping("/list-todos")
  public String getToDoList(ModelMap map){

    List<Todo> todoList = todoRepository.findByUsername(getLoggedInUsername());
    map.put("todoList",todoList);

    return "listTodo";
  }


  @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
  public String showNewTodoPage(ModelMap map){
    log.info("Inside showNewTodoPage");
    String username = getLoggedInUsername();
    Todo todo = new Todo(5,username,"",LocalDate.now().plusMonths(4),false);
    map.put("todo",todo);


    return "todos";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String addNewTodo(ModelMap map, @Valid Todo todo, BindingResult result){
    log.info("Inside addNewTodo");

    if (result.hasErrors()){

      return "todos";
    }
    String username = getLoggedInUsername();
    todo.setUsername(username);
    todoRepository.save(todo);
    //todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),todo.isDone());
    return "redirect:list-todos";
  }


  @RequestMapping("/delete-todo")
  public String deleteTodo(@RequestParam int id, ModelMap map){
  log.info("Inside Delete Todo");
  //todoService.deleteById(id);
  todoRepository.deleteById(id);
  return "redirect:list-todos";
  }


  @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
  public String showUpdatePage(@RequestParam int id, ModelMap map){
    log.info("Inside Update Todo");
    Todo todo = todoRepository.findById(id).get();
    map.put("todo",todo);
    return "todos";
  }

  @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
  public String updateTodo(ModelMap map, @Valid Todo todo, BindingResult result){
    log.info("Inside addNewTodo");

    if (result.hasErrors()){

      return "todos";
    }
    String username = getLoggedInUsername();
    todo.setUsername(username);
    todoRepository.save(todo);
    return "redirect:list-todos";
  }

  private String getLoggedInUsername(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();
  }
}
