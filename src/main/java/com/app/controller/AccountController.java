package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ExceptionHandle;
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

	@RequestMapping(path = "/permission", method = RequestMethod.POST)
	public ResponseEntity<AccountPermission> savePermission(@RequestBody AccountPermission permission)
			throws ExceptionHandle {
		return new ResponseEntity<AccountPermission>(accountService.savePermissionSrvc(permission), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) throws ExceptionHandle {
		return new ResponseEntity<Account>(accountService.registerAccountSrvc(account), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/login")
	public ResponseEntity<Account> loginAccount(@RequestBody Account account) throws ExceptionHandle {
		return new ResponseEntity<Account>(accountService.loginAccountSrvc(account), HttpStatus.OK);
	}
}
