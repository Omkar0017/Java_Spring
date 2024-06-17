package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringContoller {

  @GetMapping(path = "/filtering")
  public SomeBean filtering(){
    return new SomeBean("value1","value2","value3","value4");
  }

  @GetMapping(path = "/filtering-list")
  public List<SomeBean> filteringList(){
    return Arrays.asList(new SomeBean("value1","value2","value3","value"),
                         new SomeBean("value4","value5","value6","value"),
                         new SomeBean("value7","value8","value9","value"));
  }
}
