package com.luv2code.springdemo.service.impl;

import com.luv2code.springdemo.service.Coach;
import com.luv2code.springdemo.service.FortuneService;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;	

	// default no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}

	// setter method for injecting dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method - setTeam");
		this.team = team;		
	}
	
	@Override
	public String getDailyWorkout() {
		return "CricketCoach: Practice spin-blowing for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String makeAComplaint() {
		return "For complaints, mail here: " + emailAddress;
	}

}
