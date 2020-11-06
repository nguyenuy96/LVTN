package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.model.Account;
import com.app.model.ModifiedPassword;
import com.app.service.AccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(path = "/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public Account getAccountByUserName(@PathVariable String userName) {
		return accountService.getAccountByUsername(userName);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Account> findAllAccounts() {
		return accountService.findAllAccounts();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewAccount(@RequestBody Account account) {
		accountService.addNewUser(account);
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public void updatePassword(@Valid @RequestBody ModifiedPassword modifiedPassword) {
		accountService.changePassword(modifiedPassword);
	}

	@PatchMapping(path = "/id")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAccount(@Valid @RequestParam Long id) {
		accountService.disableAccount(id);
	}
}
