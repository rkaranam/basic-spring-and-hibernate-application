package com.luv2code.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// create the spring container
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"beanScope-applicationContext.xml");

		// retrieve beans from spring configuration file
		Coach trackCoach = appContext.getBean("trackCoach", Coach.class);

		Coach anotherTrackCoach = appContext.getBean("trackCoach", Coach.class);

		// comparing their object references
		boolean trackResult = (trackCoach == anotherTrackCoach);

		System.out.println("\nPointing to the same object: " + trackResult);
		System.out.println("\nMemory location for trackCoach: " + trackCoach);
		System.out.println("\nMemory location for anotherTrackCoach: " + anotherTrackCoach + "\n");

		Coach baseballCoach = appContext.getBean("baseballCoach", Coach.class);

		Coach anotherbaseballCoach = appContext.getBean("baseballCoach", Coach.class);

		// comparing their object references
		boolean baseballResult = (baseballCoach == anotherbaseballCoach);

		System.out.println("\nPointing to the same object: " + baseballResult);
		System.out.println("\nMemory location for baseballCoach: " + baseballCoach);
		System.out.println("\nMemory location for anotherbaseballCoach: " + anotherbaseballCoach + "\n");

		// close the context
		appContext.close();
	}

}
