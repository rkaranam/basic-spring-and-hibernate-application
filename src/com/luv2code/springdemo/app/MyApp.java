package com.luv2code.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class MyApp {

	public static void main(String[] args) {
		
		// define a spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the bean from the spring container
		Coach theCoach = context.getBean("trackCoach", Coach.class);
		
		// Make function calls from the retrieved bean		
		System.out.println(theCoach.getDailyWorkout() + " and " + theCoach.getDailyFortune());

		// close the container
		context.close();
	}

}
