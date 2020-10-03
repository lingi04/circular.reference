package com.example.circular.reference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceC {
	ServiceC(){
		System.out.println("======================");
		System.out.println("=      ServiceC      =");
		System.out.println("======================");
	}

	@Autowired
	ServiceA serviceA;

	public String callC(){
		return "Call Service C";
	}

	public String callA(){
		return "Call Service C, " + serviceA.callA();
	}

	public String circularCall(){
		return "Call Service C, " + serviceA.circularCall();
	}
}
