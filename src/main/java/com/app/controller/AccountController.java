package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping(path = "/account")
public class AccountController {
	@Value("${upload.file.directory}")
	private String uploadDirectory;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(path = "/permission")
	public ResponseEntity<AccountPermission> savePermission(@RequestBody AccountPermission permission){		
		AccountPermission permissionSaved = accountService.savePermission(permission);
		return new ResponseEntity<AccountPermission>(permissionSaved, HttpStatus.CREATED);
	}
	@PostMapping(path = "/register/{permissionid}")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account, @PathVariable("permissionid") int permissionId){
		AccountPermission accountPermission = new AccountPermission(permissionId);
		account.setPermission(accountPermission);
		Account accountSaved = accountService.registerAccount(account);
		return new ResponseEntity<Account>(accountSaved, HttpStatus.CREATED);
	}
}
