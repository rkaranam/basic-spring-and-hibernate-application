package com.luv2code.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// create the spring container
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");

		// retrieve beans from spring configuration file
		Coach trackCoach = appContext.getBean("trackCoach", Coach.class);

		// call methods on retrieved beans
		System.out.println(trackCoach.getDailyWorkout());

		// close the context
		appContext.close();
	}

}
