package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.student;
import com.example.demo.repository.studentRepository;

@Service
public class studentService {
	@Autowired
	studentRepository studRepository;
	public List<student>  getAllStudents() {
		List<student> studList=studRepository.findAll();
		return studList;
	}

	public student saveStudent(student s) {
		student obj=studRepository.save(s);
		return obj;
		//return studRepository.save(s);
	}
	
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
	
	public student getStudent(int regno)
	{
		student s=studRepository.findById(regno).get();
		return s;
	}
	
	public List<student> sortStudent(String field) {
		return studRepository.findAll(Sort.by(field));
		
	}
}
 