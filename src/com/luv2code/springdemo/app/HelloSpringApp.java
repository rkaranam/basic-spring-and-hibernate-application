package com.luv2code.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from configuration file
		Coach myCoach = context.getBean("baseballCoach", Coach.class);

		// call methods on the retrieved bean
		System.out.println(myCoach.getDailyWorkout());

		// close the context
		context.close();

	}

}
