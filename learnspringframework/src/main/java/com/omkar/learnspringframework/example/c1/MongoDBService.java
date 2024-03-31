package com.omkar.learnspringframework.example.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Primary
@Repository
public class MongoDBService implements DataService{

  @Override
  public int[] retriveData() {
    return new int[]{11,22,33,4,};
  }
}
