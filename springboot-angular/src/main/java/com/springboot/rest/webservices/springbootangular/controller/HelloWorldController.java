package com.springboot.rest.webservices.springbootangular.controller;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservices.springbootangular.bean.HelloWorldBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	//@Autowired
	//private HelloWorldBean message;
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		
		return "Hello World v2";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		//throw new RuntimeException("Some Error has been happend! Contact Support ***** ");
		  
		return new HelloWorldBean("Hello World Bean Chnaged");
	}   
    
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVarable(@PathVariable String name) {
		  
		return new HelloWorldBean(String.format("Hello World,%s ",name));
	}  
	
}
