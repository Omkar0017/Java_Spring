package com.in28minutes.spring.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

  @Autowired
  private AuthenticationService authenticationService;

  private Logger log = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }


  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String gotoWelcomePage(@RequestParam String name, @RequestParam String password,
      ModelMap map) {

    if (authenticationService.authentication(name, password)) {
      map.put("name", name);
      return "welcome";
    }

    map.put("error","Invalid Credentials");
    return "login";
  }
}
