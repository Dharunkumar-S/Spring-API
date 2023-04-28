package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studRepository;

	public List<Student> getAllStudents() {
		List<Student> studList = studRepository.findAll();
		return studList;
	}

	public Student saveStudent(Student s) {
		Student obj = studRepository.save(s);
		return obj;
		// return studRepository.save(s);
	}

}
