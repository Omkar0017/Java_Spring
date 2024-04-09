package com.in28minutes.spring.myfirstwebapp.todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

  @Autowired
  TodoService todoService;


  @RequestMapping("/todo-list")
  public String getToDoList(ModelMap map){

    List<Todo> todoList = todoService.findByUsername("omkar");
    map.put("todoList",todoList);

    return "listTodo";
  }



}
