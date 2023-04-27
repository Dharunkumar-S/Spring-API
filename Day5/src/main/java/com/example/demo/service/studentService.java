package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.student;
import com.example.demo.repository.studentRepository;

@Service
public class studentService {
	@Autowired
	studentRepository studRepository;
	
	public  student updateStudent(student s,int rno) {
		Optional<student> optional=studRepository.findById(rno);
		student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			studRepository.save(s);
		}
		return obj;
	}
	
	public void deleteStudent(int regno) {
		studRepository.deleteById(regno);
	}
}
 