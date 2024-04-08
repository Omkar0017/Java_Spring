package com.in28minutes.spring.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

private Logger log =  LoggerFactory.getLogger(getClass());
  @RequestMapping("/login")
  public String loginPage(@RequestParam String name, ModelMap model){
    log.info("Request Parameter is---->"+name);
    System.out.println("Request Parameter is---->"+ name);

    model.put("name",name);
    return "login";
  }
}
