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
	
	@GetMapping(value="/getStudent/{rno}")
	public student getStudent(@PathVariable("rno") int regno)
	{
		return studService.getStudent(regno);
	}
	
	 @GetMapping(value="/sortStudent/{field}")
	 public List<student> sortStudent(@PathVariable("field") String field)
	 {
		 return studService.sortStudent(field);
	 }
	 
	 
}
