package com.in28minutes.spring.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
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
  public String showNewTodoPage(){
    return "todos";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String addNewTodo(@RequestParam String description,ModelMap map ){
    String username = (String) map.get("name");
    todoService.addTodo(username,description, LocalDate.now().plusYears(1),false);
    return "redirect:list-todos";
  }


}
