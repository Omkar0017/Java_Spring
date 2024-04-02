package com.in28minute.springboot.learnjpaandhibernate.course;

import com.in28minute.springboot.learnjpaandhibernate.course.Course;
import com.in28minute.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

  @Autowired
  private  CourceJPARepository courceJPARepository;


  @Override
  public void run(String... args) throws Exception {
    courceJPARepository.insert(new Course(1,"JAVA","Ranga"));
    courceJPARepository.insert(new Course(2,"IAM","Srushti"));
    courceJPARepository.insert(new Course(3,"React","Danny"));


    System.out.println(courceJPARepository.findById(3).toString());

    courceJPARepository.deleteById(1);
  }
//  @Autowired
//  private CourseJDBCRepository repository;
//
//
//  @Override
//  public void run(String... args) throws Exception {
//      repository.insert(new Course(1,"JAVA","Ranga"));
//      repository.insert(new Course(2,"IAM","Srushti"));
//      repository.insert(new Course(3,"React","Danny"));
//
//      repository.deleteById(2);
//
//      System.out.println(repository.selectById(3).toString());
//  }




}
