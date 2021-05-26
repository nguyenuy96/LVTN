package com.app.controller;

import com.app.dto.AccountDTO;
import com.app.dto.AccountReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.model.Account;
import com.app.dto.ModifiedPassword;
import com.app.service.AccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(path = "/{user_name}")
	@ResponseStatus(HttpStatus.OK)
	public AccountDTO getAccountByUserName(@PathVariable(value = "user_name") String userName) {
		return accountService.getAccountByUsername(userName);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Account> findAllAccounts() {
		return accountService.findAllAccounts();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewAccount(@RequestBody AccountReq request) {
		accountService.addNewUser(request);
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
