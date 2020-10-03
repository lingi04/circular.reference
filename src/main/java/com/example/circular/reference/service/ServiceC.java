package com.example.circular.reference.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceC {
	final
	ServiceA serviceA;

	ServiceC(ServiceA serviceA){
		System.out.println("======================");
		System.out.println("=      ServiceC      =");
		System.out.println("======================");
		this.serviceA = serviceA;
	}

	public String callC(){
		return "Call Service C";
	}

	public String circularCall(){
		return "Call Service C, " + serviceA.circularCall();
	}
}
