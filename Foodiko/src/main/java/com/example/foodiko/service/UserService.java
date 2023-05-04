package com.example.foodiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodiko.model.User;
import com.example.foodiko.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	UserRepository uRepo;
	
	public User signup(User u) {
		return uRepo.save(u);
	}
	
	public String loginAuth(String username,String password)
	{
		User user = uRepo.findByusername(username);
		if(user == null) {
			return "No User Found Please Try Again!!!!";
		}
		else {
			if(user.getPassword().equals(password)) {
				return "Login Successful";
			}
			else {
				return "Login Failed";
			}
		}
	}

	public List<User> getAllUser() {
		List<User> uList=uRepo.findAll();
		return uList;
	}

	public void deleteUser(int id) {
		uRepo.deleteById(id);
	}
	
}
