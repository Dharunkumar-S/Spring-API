package com.example.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;
	
	public List<Account> getAllAccounts() {
		List<Account> accList=accRepo.findAll();
		return accList;
	}

	public Account saveAccount(Account a) {
		Account acc=accRepo.save(a);
		return acc;
	}

	public Account updateAccount(Account a) {
		Account acc=accRepo.save(a);
		return acc;
	}

	public void deleteAccount(int id) {
		accRepo.deleteById(id);
	}

	public Account getAccount(int id) {
		Account acc=accRepo.findById(id).get();
		return acc;
	}

}
