package com.example.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	public List<BusModel> sort(String field) {
		return  bRepo.findAll(Sort.by(field));

	}

	public List<BusModel> rsort(String field) {
		return bRepo.findAll(Sort.by(Direction.DESC, field));

	}

	public List<BusModel> paging(int offset, int pageSize) {
		Pageable paging = PageRequest.of(offset, pageSize);
		Page<BusModel> bData = bRepo.findAll(paging);
		List<BusModel> bList = bData.getContent();
		return bList;
	}
}
