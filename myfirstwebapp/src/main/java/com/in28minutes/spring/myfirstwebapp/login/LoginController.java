package com.in28minutes.spring.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


  @RequestMapping("/login")
  public String loginPage(@RequestParam String name, ModelMap model){
    System.out.println("Request Parameter is---->"+ name);

    model.put("name",name);
    return "login";
  }
}
