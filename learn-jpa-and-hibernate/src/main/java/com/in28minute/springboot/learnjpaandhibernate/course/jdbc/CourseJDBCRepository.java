package com.in28minute.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

  @Autowired
  private JdbcTemplate springJdbcTemplate;
  private static String query =
      """ 
      insert into course (id, name, author) values(2, 'Learn Python','Telusko');
      """;


  public void insert(){

    springJdbcTemplate.update(query);
  }
}
