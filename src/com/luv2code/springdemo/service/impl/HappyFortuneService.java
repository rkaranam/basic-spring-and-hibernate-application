package com.luv2code.springdemo.service.impl;

import com.luv2code.springdemo.service.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Yay, You are lucky today!";
	}

}
