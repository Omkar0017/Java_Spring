package com.in28minute.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minute.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
  @Autowired
  private CourseJDBCRepository repository;


  @Override
  public void run(String... args) throws Exception {
      repository.insert(new Course(1,"JAVA","Ranga"));
      repository.insert(new Course(2,"IAM","Srushti"));
      repository.insert(new Course(3,"React","Danny"));

      repository.deleteById(2);

      System.out.println(repository.selectById(3).toString());
  }


}
