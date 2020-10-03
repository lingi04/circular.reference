package com.example.circular.reference.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {
	final
	ServiceB serviceB;

	ServiceA(ServiceB serviceB){
		System.out.println("======================");
		System.out.println("=      ServiceA      =");
		System.out.println("======================");
		this.serviceB = serviceB;
	}

	public String callA(){
		return "Call Service A";
	}

	public String circularCall(){
		return "Call Service A, " + serviceB.circularCall();
	}
}
