package com.in28minutes.spring.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

private Logger log =  LoggerFactory.getLogger(getClass());
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage(){
    return "login";
  }


  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String gotoWelcomePage(@RequestParam String name , @RequestParam String password, ModelMap map){
    map.put("name",name);
    return "welcome";
  }
}
