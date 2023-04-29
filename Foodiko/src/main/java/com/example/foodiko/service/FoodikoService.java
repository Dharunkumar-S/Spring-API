package com.example.foodiko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.foodiko.model.Foodiko;
import com.example.foodiko.repository.FoodikoRepository;

@Service
public class FoodikoService {
	@Autowired
	FoodikoRepository fRepo;

	public List<Foodiko> getAll() {
		List<Foodiko> fList=fRepo.findAll();
		return fList;
	}

	public Foodiko save(Foodiko f) {
		Foodiko obj=fRepo.save(f);
		return obj;
	}

	public Foodiko update(Foodiko f, int id) {
		Optional<Foodiko> optional=fRepo.findById(id);
		Foodiko obj=null;
		if(optional.isPresent()) {
			obj=optional.get();
			fRepo.save(f);
		}
		return obj;
	}

	public void delete(int id) {
		fRepo.deleteById(id);
	}
	
	public Foodiko get(int id) {
		Foodiko f=fRepo.findById(id).get();
		return f;
	}

	public List<Foodiko> sort(String field) {
		return fRepo.findAll(Sort.by(field));
	}

	public List<Foodiko> rsort(String field) {
		return fRepo.findAll(Sort.by(Direction.DESC,field));
	}

	public List<Foodiko> paging(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Foodiko> fData=fRepo.findAll(paging);
		List<Foodiko> fList=fData.getContent();
		return fList;
	}

	public List<Foodiko> pagingAndSorting(int offset, int pageSize, String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Foodiko> fData=fRepo.findAll(paging);
		List<Foodiko> fList=fData.getContent();
		return fList;
	}
	
	public List<Foodiko> rpagingAndSorting(int offset, int pageSize, String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Foodiko> fData=fRepo.findAll(paging);
		List<Foodiko> fList=fData.getContent();
		return fList;
	}
	
}
