package com.in28minute.springboot.learnjpaandhibernate.course;

public class Course {

  private int id;
  private String name;
  private String author;

  public Course(){

  }

  public Course(int id, String name, String author) {
    this.id = id;
    this.name = name;
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author='" + author + '\'' +
        '}';
  }
}