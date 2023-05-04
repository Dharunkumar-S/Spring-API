package com.example.foodiko.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodiko.model.User;
import com.example.foodiko.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

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
	
	@Operation(summary = "Get all Users")
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		List<User> uList=uService.getAllUser();
		return uList;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		uService.deleteUser(id);
	}
	
}
