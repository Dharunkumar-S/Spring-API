package com.example.foodiko.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodiko.model.User;
import com.example.foodiko.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService uService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User u) {
		return uService.signup(u);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String,String> l) {
		String username = l.get("username");
		String password = l.get("password");
		String result=uService.loginAuth(username,password);
		return result;
	}
}
