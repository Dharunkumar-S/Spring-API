package com.example.foodiko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodiko.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByusername(String username);
	
}
