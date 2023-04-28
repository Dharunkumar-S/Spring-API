package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studRepository;
	
	public  Student updateStudent(Student s,int rno) {
		Optional<Student> optional=studRepository.findById(rno);
		Student obj=null;
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
 