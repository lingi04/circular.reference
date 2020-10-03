package com.example.circular.reference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
	ServiceA(){
		System.out.println("======================");
		System.out.println("=      ServiceA      =");
		System.out.println("======================");
	}

	@Autowired
	ServiceC serviceC;

	public String callA(){
		return "Call Service A";
	}

	public String circularCall(){
		return "Call Service A, " + serviceC.circularCall();
	}
}
