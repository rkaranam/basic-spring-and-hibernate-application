package com.luv2code.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.impl.CricketCoach;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring container
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve beans from Spring Configuration file
		CricketCoach cricketCoach = appContext.getBean("cricketCoach", CricketCoach.class);
		
		// make calls on the retrieved beans
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getTeam());
		System.out.println(cricketCoach.getEmailAddress());
		
		System.out.println(cricketCoach.makeAComplaint());
		
		// close the app context
		appContext.close();

	}

}
