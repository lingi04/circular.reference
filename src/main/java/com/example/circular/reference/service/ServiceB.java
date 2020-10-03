package com.example.circular.reference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
	ServiceB(){
		System.out.println("======================");
		System.out.println("=      ServiceB      =");
		System.out.println("======================");
	}

	@Autowired
	ServiceA serviceA;

	public String callB(){
		return "Call Service B";
	}

	public String circularCall(){
		return "Call Service B, " + serviceA.circularCall();
	}
}
