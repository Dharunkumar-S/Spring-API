package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	public boolean deleteStudent(int regno) {
		boolean result=false;
		studRepository.deleteById(regno);
		Optional <student> s= studRepository.findById(regno);
		if(s.isEmpty())
		{
			result=true;
		}
		return result;
	}
	
	public student getStudent(int regno)
	{
		student s=studRepository.findById(regno).get();
		return s;
	}
	
	public List<student> sortStudent(String field) {
		return studRepository.findAll(Sort.by(Direction.DESC,field));
//		return studRepository.findAll(Sort.by(field));
		
	}

	public List<student> pagingStudents(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<student> studData=studRepository.findAll(paging);
		List<student> studList=studData.getContent();
		return studList;
	}
	
//	public Page<student> pagingStudents(int offset, int pageSize) {
//		Pageable paging=PageRequest.of(offset,pageSize);
//		Page<student> studData=studRepository.findAll(paging);
//		return studData;
//	}
	public List<student> pagingAndSortingStudents(int offset, int pageSize,String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<student> studData=studRepository.findAll(paging);
		List<student> studList=studData.getContent();
		return studList;
	}
}
 