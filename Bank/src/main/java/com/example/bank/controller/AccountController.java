package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Account;
import com.example.bank.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	AccountService accService;
	
	@GetMapping("/fetchAccount")
	public List<Account> getAllAccount() {
		List<Account> accList=accService.getAllAccounts();
		return accList;
	}
	
	@PostMapping("/saveAccount")
	public Account saveAccount(@RequestBody Account a) {
		return accService.saveAccount(a);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestBody Account a) {
		return accService.updateAccount(a);
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public void deleteAccount(@PathVariable("id") int id) {
		accService.deleteAccount(id);
	}
	
	@PostMapping("/getAccount/{id}")
	public Account getAccount(@PathVariable("id") int id) {
		return accService.getAccount(id);
	}
	
}
