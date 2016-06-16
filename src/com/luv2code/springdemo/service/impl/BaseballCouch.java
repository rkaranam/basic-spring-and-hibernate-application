package com.luv2code.springdemo.service.impl;

import com.luv2code.springdemo.service.Coach;
import com.luv2code.springdemo.service.FortuneService;

public class BaseballCouch implements Coach {
	
	// define a private field for dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCouch(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Start practicing batting for 30 minutes!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
