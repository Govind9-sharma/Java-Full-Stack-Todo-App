package com.jdbc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.entity.User;
import com.jdbc.service.UserService;

@CrossOrigin(origins="https://full-stack-project-8b5c7.web.app/")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		String id=UUID.randomUUID().toString();
		user.setId(id);
		return ResponseEntity.ok(service.createUser(user));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser()
	{
		return ResponseEntity.ok(service.getAllUser());
	}
}
