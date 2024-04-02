package com.in28minute.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minute.springboot.learnjpaandhibernate.course.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourceSpringDataJPA extends JpaRepository<Course,Long> {

  List<Course> findByAuthor(String author);
  List<Course> findByName(String name);

}
