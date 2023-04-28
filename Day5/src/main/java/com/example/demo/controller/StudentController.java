package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studService;
	
	@PutMapping(value="/updateStudent/{rno}")
	public Student updateStudent(@RequestBody Student s,@PathVariable("rno") int regno)
	{
		return studService.updateStudent(s,regno);
	}
	
	@DeleteMapping(value="/deleteStudent/{rno}")
	public void deleteStudent(@PathVariable("rno") int regno)
	{
		studService.deleteStudent(regno);
	}
	 
}
