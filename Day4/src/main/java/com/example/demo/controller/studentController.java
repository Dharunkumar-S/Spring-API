package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.student;
import com.example.demo.service.studentService;

@RestController
public class studentController {
	@Autowired
	studentService studService;
	
	@GetMapping(value="/fetchStudent")
	public List<student> getAllStudents() {
		List<student> studList=studService.getAllStudents();
		return studList;
	}
	
	@PostMapping(value="/saveStudent")
	public student savestudent(@RequestBody student s)
	{
		return studService.saveStudent(s);
	}
	
}
