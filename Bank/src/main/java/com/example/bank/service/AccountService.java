package com.example.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;

	public List<Account> getAllAccounts() {
		List<Account> accList = accRepo.findAll();
		return accList;
	}

	public Account saveAccount(Account a) {
		Account acc = accRepo.save(a);
		return acc;
	}

	public Account updateAccount(Account a) {
		Account acc = accRepo.save(a);
		return acc;
	}

	public void deleteAccount(int id) {
		accRepo.deleteById(id);
	}

	public Account getAccount(int id) {
		Account acc = accRepo.findById(id).get();
		return acc;
	}

	public List<Account> sortAccount(String field) {
		return accRepo.findAll(Sort.by(field));

	}

	public List<Account> rsortAccount(String field) {
		return accRepo.findAll(Sort.by(Direction.DESC, field));

	}

	public List<Account> pagingAccount(int offset, int pageSize) {
		Pageable paging = PageRequest.of(offset, pageSize);
		Page<Account> accData = accRepo.findAll(paging);
		List<Account> accList = accData.getContent();
		return accList;
	}
	
	public List<Account> pagingAndSortingAccounts(int offset, int pageSize,String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Account> accData=accRepo.findAll(paging);
		List<Account> accList=accData.getContent();
		return accList;
	}
}
