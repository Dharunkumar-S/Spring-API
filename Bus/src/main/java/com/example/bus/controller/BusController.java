package com.example.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus.model.BusModel;
import com.example.bus.service.BusService;

@RestController
public class BusController {
	
	@Autowired
	BusService bService;
	
	@GetMapping("/getAll")
	public List<BusModel> getAll(){
		List<BusModel> bList=bService.getAll();
		return bList;
	}
	
	@PostMapping("/save")
	public BusModel save(@RequestBody BusModel b) {
		return bService.save(b);
	}
	
	@PutMapping("/update/{id}")
	public BusModel update(@RequestBody BusModel b,@PathVariable("id") int id) {
		return bService.update(b,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		bService.delete(id);
		return "Deleted!";
	}
	
	@GetMapping("/get/{id}")
	public BusModel get(@PathVariable("id") int id) {
		return bService.get(id);
	}
}
