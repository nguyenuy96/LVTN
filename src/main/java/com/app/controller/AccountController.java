package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Account;
import com.app.model.ModifiedPassword;
import com.app.service.AccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private AccountService accountService;

	@GetMapping(path = "/{userName}")
	public ResponseEntity<Account> getAccountByUserName(@PathVariable String userName) {
		return new ResponseEntity<>(accountService.getAccountByUsername(userName), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> addNewAccount(@RequestBody Account account) {
		accountService.addNewUser(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<HttpStatus> updatePassword(@Valid @RequestBody ModifiedPassword modifiedPassword) {
		accountService.changePassword(modifiedPassword);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Account>> findAllAccounts() {
		return new ResponseEntity<>(accountService.findAllAccounts(), HttpStatus.OK);
	}
}
