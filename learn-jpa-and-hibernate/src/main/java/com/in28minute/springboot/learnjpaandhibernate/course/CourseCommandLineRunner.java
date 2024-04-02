package com.in28minute.springboot.learnjpaandhibernate.course;

import com.in28minute.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.in28minute.springboot.learnjpaandhibernate.course.jpa.CourceJPARepository;
import com.in28minute.springboot.learnjpaandhibernate.course.springdatajpa.CourceSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//  @Autowired
//  private CourceJPARepository courceJPARepository;

//  @Autowired
//  private CourseJDBCRepository repository;


  @Autowired
  CourceSpringDataJPA repository;

//  @Override
//  public void run(String... args) throws Exception {
//    courceJPARepository.insert(new Course(1,"JAVA","Ranga"));
//    courceJPARepository.insert(new Course(2,"IAM","Srushti"));
//    courceJPARepository.insert(new Course(3,"React","Danny"));
//
//
//    System.out.println(courceJPARepository.findById(3).toString());
//
//    courceJPARepository.deleteById(1);
//  }


  @Override
  public void run(String... args) throws Exception {
      repository.save(new Course(1,"JAVA","Ranga"));
      repository.save(new Course(2,"IAM","Srushti"));
      repository.save(new Course(3,"React","Danny"));

      repository.deleteById(2L);

      //System.out.println(repository.selectById(3L).toString());

    System.out.println(repository.findById(1L).toString());
    System.out.println(repository.findAll());

    System.out.println(repository.findByAuthor("Danny"));
    System.out.println(repository.findByName("JAVA"));



  }




}
