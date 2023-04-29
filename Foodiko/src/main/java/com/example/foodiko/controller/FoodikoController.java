package com.example.foodiko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodiko.model.Foodiko;
import com.example.foodiko.service.FoodikoService;

@RestController
public class FoodikoController {
	@Autowired
	FoodikoService fService;
	
	@GetMapping("/getAll")
	public List<Foodiko> getAll(){
		List<Foodiko> fList=fService.getAll();
		return fList;
	}
	
	@PostMapping("/save")
	public Foodiko save(@RequestBody Foodiko f) {
		return fService.save(f);
	}
	
	@PutMapping("/update/{id}")
	public Foodiko update(@RequestBody Foodiko f,@PathVariable int id) {
		return fService.update(f,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		fService.delete(id);
	}
	
	@GetMapping("/get/{id}")
	public Foodiko get(@PathVariable int id) {
		return fService.get(id);
	}
	
	@GetMapping("/sort/{field}")
	public List<Foodiko> sort(@PathVariable String field) {
		return fService.sort(field);
	}
	
	@GetMapping("/rsort/{field}")
	public List<Foodiko> rsort(@PathVariable String field) {
		return fService.rsort(field);
	}
	
	@GetMapping("/paging/{offset}/{pageSize}")
	public List<Foodiko> paging(@PathVariable int offset,@PathVariable int pageSize) {
		return fService.paging(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSorting/{offset}/{pageSize}/{field}")
	public List<Foodiko> pagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) {
		return fService.pagingAndSorting(offset,pageSize,field);
	}
	
	@GetMapping("/rpagingAndSorting/{offset}/{pageSize}/{field}")
	public List<Foodiko> rpagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) {
		return fService.rpagingAndSorting(offset,pageSize,field);
	}
	
}
