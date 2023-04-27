package com.example.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bus.model.BusModel;
import com.example.bus.repository.BusRepository;

@Service
public class BusService {
	@Autowired
	BusRepository bRepo;

	public List<BusModel> getAll() {
		List<BusModel> bList=bRepo.findAll();
		return bList;
	}

	public BusModel save(BusModel b) {
		BusModel obj=bRepo.save(b);
		return obj;
	}

	public BusModel update(BusModel b, int id) {
		Optional<BusModel> opt=bRepo.findById(id);
		BusModel obj=null;
		if(opt.isPresent()) {
			obj=opt.get();
			bRepo.save(b);
		}
		return obj;
	}

	public void delete(int id) {
		bRepo.deleteById(id);
	}

	public BusModel get(int id) {
		BusModel obj=bRepo.findById(id).get();
		return obj;
	}
}
