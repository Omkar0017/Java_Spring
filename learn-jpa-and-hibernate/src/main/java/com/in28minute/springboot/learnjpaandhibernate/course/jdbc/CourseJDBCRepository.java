package com.in28minute.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minute.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

  @Autowired
  private JdbcTemplate springJdbcTemplate;
  private static String insert_query =
      """ 
      insert into course (id, name, author) values(?,?,?);
      """;

  private static String delete_query =
      """ 
      DELETE FROM  course WHERE ID = ?;
      """;

  public void insert(Course course){

    springJdbcTemplate.update(insert_query,course.getId(),course.getName(),course.getAuthor());
  }

  public void deleteById(Integer id){
    springJdbcTemplate.update(delete_query,id);
    System.out.println("Delete Operation performed");
  }
}
