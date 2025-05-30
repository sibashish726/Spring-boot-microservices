package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class HomeController {
	
	@RequestMapping("/")
    public String home() {
    	return "Hello World!";
    }
	
	@GetMapping("/user")
	//@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public User user() {
		User user=new User();
		user.setName("Sibashish Biswas");
		user.setId("20250001");
		user.setEmail("Sibashish.Biswas@lumen.com");
		
		return user;
	}
	
	@GetMapping("/user/{id}")
	public String getId(@PathVariable String id) {
		
		return "Path variable is "+id;
	}
	
	@GetMapping("/requestParam")
	public String RequestParam(@org.springframework.web.bind.annotation.RequestParam String name, 
			                   @org.springframework.web.bind.annotation.RequestParam(required = false, defaultValue = "default@lumen.com") String email) {
		return "Request body name is "+name +" "+email;
	}
	
}
