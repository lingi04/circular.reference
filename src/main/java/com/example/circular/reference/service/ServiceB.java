package com.example.circular.reference.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {
	final
	ServiceC serviceC;

	ServiceB(ServiceC serviceC){
		System.out.println("======================");
		System.out.println("=      ServiceB      =");
		System.out.println("======================");
		this.serviceC = serviceC;
	}

	public String callB(){
		return "Call Service B";
	}

	public String circularCall(){
		return "Call Service B, " + serviceC.circularCall();
	}
}
