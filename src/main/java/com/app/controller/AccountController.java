package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Account;
import com.app.model.ModifiedPassword;
import com.app.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping(path = "/account")
public class AccountController {
	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<Account> getAccountByUserName(@RequestParam String userName) {
		return new ResponseEntity<>(accountService.getAccountByUsername(userName), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> addNewAccount(@RequestBody Object request) {
		accountService.addNewUser(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<HttpStatus> updatePassword(@RequestBody ModifiedPassword modifiedPassword) {
		accountService.changePassword(modifiedPassword);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
