package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
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
	
	@GetMapping("/fetchStudent")
	public List<student> getAllStudents() {
		List<student> studList=studService.getAllStudents();
		return studList;
	}
	
	@PostMapping("/saveStudent")
	public student savestudent(@RequestBody student s)
	{
		return studService.saveStudent(s);
	}
	
	@PutMapping("/updateStudent/{rno}")
	public student updateStudent(@RequestBody student s,@PathVariable("rno") int regno)
	{
		return studService.updateStudent(s,regno);
	}
	
	@DeleteMapping("/deleteStudent/{rno}")
	public boolean deleteStudent(@PathVariable("rno") int regno)
	{
		boolean result=studService.deleteStudent(regno);
		return result;
	}
	
	@GetMapping("/getStudent/{rno}")
	public student getStudent(@PathVariable("rno") int regno)
	{
		return studService.getStudent(regno);
	}
	
	 @GetMapping("/sortStudent/{field}")
	 public List<student> sortStudent(@PathVariable("field") String field)
	 {
		 return studService.sortStudent(field);
	 }
	 
	 @GetMapping("pagingStudents/{offset}/{pageSize}")
	 public List<student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
		 return studService.pagingStudents(offset,pageSize);
	 }
	 
	 
	 @GetMapping("pagingStudents/{offset}/{pageSize}/{field}")
	 public List<student> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return studService.pagingAndSortingStudents(offset,pageSize,field);
	 }
	 
//	 @GetMapping("pagingStudents/{offset}/{pageSize}")
//	 public Page<student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
//		 return studService.pagingStudents(offset,pageSize);
//	 }
	 
}
