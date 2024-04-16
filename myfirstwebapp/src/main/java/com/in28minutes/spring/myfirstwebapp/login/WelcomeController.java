package com.in28minutes.spring.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {



  private Logger log = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String gotoWelcomePage(ModelMap map) {

    map.put("name", "omkar");
    return "login";
  }



}
