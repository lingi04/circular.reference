package com.example.circular.reference.controller;

import com.example.circular.reference.service.ServiceA;
import com.example.circular.reference.service.ServiceB;
import com.example.circular.reference.service.ServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
	@Autowired
	ServiceA serviceA;
	@Autowired
	ServiceB serviceB;
	@Autowired
	ServiceC serviceC;

	@GetMapping("circularCall")
	public String circularCall(){
		return serviceA.circularCall();
	}
}
