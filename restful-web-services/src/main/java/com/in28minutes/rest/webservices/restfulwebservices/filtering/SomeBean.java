package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonFilter("SomeBeanFilter")
@Data
//@JsonIgnoreProperties("field4")
public class SomeBean {

  private String field1 ;
//  @JsonIgnore  //Static filetring
  private String field2 ;
  private String field3 ;
  private String field4 ;

  public SomeBean(String field1, String field2, String field3, String field4) {
    this.field1 = field1;
    this.field2 = field2;
    this.field3 = field3;
    this.field4 = field4;
  }
}
