package com.project.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.entity.User;
import com.project.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	
	
	@Autowired 
	PasswordEncoder passEncoder;
	
	@PostMapping("register")
	public  ResponseEntity<User> register(@RequestBody User user) {
		
		String pass= user.getPassword();
		user.setPassword(passEncoder.encode(pass));
        return ResponseEntity.ok(userService.saveUser(user));

	}
	
	
	@PostMapping("login")
	public String login(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	

}
