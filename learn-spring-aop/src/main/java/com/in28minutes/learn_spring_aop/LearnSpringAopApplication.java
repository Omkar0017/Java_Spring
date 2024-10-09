package com.in28minutes.learn_spring_aop;

import com.in28minutes.learn_spring_aop.aopexample.business.BusinessService1;
import com.in28minutes.learn_spring_aop.aopexample.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(LearnSpringAopApplication.class);

	private BusinessService1 businessService1;
	private BusinessService2 businessService2;

	public LearnSpringAopApplication(BusinessService1 businessService1,BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Max Value returned is {}",businessService1.calculateMAx());
		log.info("Min Value returned is {}",businessService2.calculateMin());
	}
}
