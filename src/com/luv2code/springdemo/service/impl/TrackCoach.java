package com.luv2code.springdemo.service.impl;

import com.luv2code.springdemo.service.Coach;
import com.luv2code.springdemo.service.FortuneService;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Start running atleast 5km in the morning!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// init method
	public void trackCoachStartupMethod() {
		System.out.println("TrackCoach: Inside method - trackCoachStartupMethod");
	}
	
	// destroy method
	public void trackCoachCleanupMethod() {
		System.out.println("TrackCoach: Inside method - trackCoachCleanupMethod");
	}

}
