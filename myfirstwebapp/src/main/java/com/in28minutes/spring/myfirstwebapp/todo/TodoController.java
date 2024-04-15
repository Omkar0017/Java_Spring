package com.in28minutes.spring.myfirstwebapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TodoController {

  @Autowired
  TodoService todoService;


  @RequestMapping("/list-todos")
  public String getToDoList(ModelMap map){

    List<Todo> todoList = todoService.findByUsername("omkar");
    map.put("todoList",todoList);

    return "listTodo";
  }


  @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
  public String showNewTodoPage(ModelMap map){
    log.info("Inside showNewTodoPage");
    String username = (String) map.get("name");
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
    String username = (String) map.get("name");
    todoService.addTodo(username,todo.getDescription(), LocalDate.now().plusYears(1),false);
    return "redirect:list-todos";
  }


}
