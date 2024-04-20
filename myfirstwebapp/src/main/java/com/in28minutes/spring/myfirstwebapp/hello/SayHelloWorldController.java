package com.in28minutes.spring.myfirstwebapp.hello;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class SayHelloWorldController {


  @RequestMapping("/say-hello")
  @ResponseBody
  public String sayHello(){
    return "Hello !! How are you today?";
  }

  @RequestMapping("/say-hello-html")
  @ResponseBody
  public String sayHelloHtml(){

    log.info("----Inside sayHelloHTML---");
    StringBuffer sb  = new StringBuffer();
    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>My first web page</title>");
    sb.append("</head>");
    sb.append("<h1>My first html page with html</h1>");
    sb.append("<h3>Changed</h3>");
    sb.append("</body>");
    sb.append("</html>");

    return sb.toString();
  }

  @RequestMapping("say-hello-jsp")
  public String sayHelloJsp() {
    log.info("-----INnside sayHelloJSP-----");
    System.out.println("Inside hellojsp");
    return "sayHello";
  }

}
