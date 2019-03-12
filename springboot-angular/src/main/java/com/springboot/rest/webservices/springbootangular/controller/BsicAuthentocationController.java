package com.springboot.rest.webservices.springbootangular.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservices.springbootangular.bean.AuthenticationBean;

@CrossOrigin("http://localhost:4200")
@RestController
public class BsicAuthentocationController {
	
	@GetMapping(path="/basicauth")
	
	public AuthenticationBean authenticationBean() {
		
		return new AuthenticationBean("Your are Authenticated");
	}

}
