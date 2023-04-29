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
		List<Account> accList = accService.getAllAccounts();
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
	public void deleteAccount(@PathVariable int id) {
		accService.deleteAccount(id);
	}

	@GetMapping("/getAccount/{id}")
	public Account getAccount(@PathVariable int id) {
		return accService.getAccount(id);
	}

	@GetMapping("/sortAccount/{field}")
	public List<Account> sortStudent(@PathVariable String field) {
		return accService.sortAccount(field);
	}

	@GetMapping("/rsortAccount/{field}")
	public List<Account> rsortStudent(@PathVariable String field) {
		return accService.rsortAccount(field);
	}

	@GetMapping("/pagingAccount/{offset}/{pageSize}")
	public List<Account> pagingStudents(@PathVariable int offset, @PathVariable int pageSize) {
		return accService.pagingAccount(offset, pageSize);
	}
	
	@GetMapping("/pagingAccounts/{offset}/{pageSize}/{field}")
	 public List<Account> pagingAndSortingAccounts(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return accService.pagingAndSortingAccounts(offset,pageSize,field);
	 }
}
