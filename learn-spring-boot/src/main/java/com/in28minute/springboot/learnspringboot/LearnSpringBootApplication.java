package com.in28minute.springboot.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		System.out.println("Starting Application");
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
