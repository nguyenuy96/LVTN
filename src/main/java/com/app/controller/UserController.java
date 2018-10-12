package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;
import com.app.model.ModifyPassword;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/role", method = RequestMethod.POST)
	public ResponseEntity<Role> savePermission(@RequestBody Role role) throws ExceptionHandle {
		return new ResponseEntity<Role>(userService.saveOrUpdateRoleSrvc(role), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/detail")
	public ResponseEntity<Account> accountDetail(@RequestBody Account account) throws ExceptionHandle {
		return new ResponseEntity<Account>(userService.accountDetailSrvc(account), HttpStatus.OK);
	}

	@RequestMapping(path = "/customer/{role}", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> customerAccount(@PathVariable int role) {
		return new ResponseEntity<List<Account>>(userService.getCustomerAccount(role), HttpStatus.OK);
	}

	@RequestMapping(path = "/employee/{role}", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> employeeAccount(@PathVariable int role) {
		return new ResponseEntity<List<Account>>(userService.getEmployeeAccount(role), HttpStatus.OK);
	}

	@RequestMapping(path = "/validate/{username}", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> validateUsername(@PathVariable String username) throws ExceptionHandle {
		userService.checkUsername(username);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/saveuser", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveOrUpdate(@RequestBody List<Object> lstUserProp) throws ExceptionHandle {
		userService.saveUserSrvc(lstUserProp);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/updatepassword", method = RequestMethod.PATCH)
	public ResponseEntity<HttpStatus> updatePassword(@RequestBody ModifyPassword modifyPassword)
			throws ExceptionHandle {
		userService.modifyPasswordSrvc(modifyPassword);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/checkaccount", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> checkAccount(@RequestBody Account account) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/updateprofile", method = RequestMethod.PATCH)
	public ResponseEntity<HttpStatus> updateProfile(@RequestBody Object profile) throws ExceptionHandle {
		userService.updateProfile(profile);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/getcusprof")
	public ResponseEntity<Customer> getCusProfile(@RequestBody Account account) {
		Customer customer = userService.getCusProfile(account);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> registerUser(@RequestBody Customer customer) throws ExceptionHandle {
		userService.registerUserSrvc(customer);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
