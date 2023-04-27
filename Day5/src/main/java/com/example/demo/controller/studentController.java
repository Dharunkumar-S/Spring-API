package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.student;
import com.example.demo.service.studentService;

@RestController
public class studentController {
	@Autowired
	studentService studService;
	
	@PutMapping(value="/updateStudent/{rno}")
	public student updateStudent(@RequestBody student s,@PathVariable("rno") int regno)
	{
		return studService.updateStudent(s,regno);
	}
	
	@DeleteMapping(value="/deleteStudent/{rno}")
	public void deleteStudent(@PathVariable("rno") int regno)
	{
		studService.deleteStudent(regno);
	}
	 
}
