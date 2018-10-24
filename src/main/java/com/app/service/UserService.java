package com.app.service;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.ModifyPassword;

public interface UserService {

	// role
	Role saveOrUpdateRoleSrvc(Role role) throws ExceptionHandle;
	
	List<Role> listRole();

	// create user
	void saveUserSrvc(Object userObj) throws ExceptionHandle;

	void registerUserSrvc(Customer customer) throws ExceptionHandle;

	// modify user
	void modifyPasswordSrvc(ModifyPassword modifyPassword) throws ExceptionHandle;

	void updateProfile(Object profile) throws ExceptionHandle;

	// get user
	List<Customer> getCustomerAccount();

	List<Employee> getEmployeeAccount();

	Customer getCusProfile(Account account);

	Account accountDetailSrvc(Account account) throws ExceptionHandle;

	// other
	Account findAccountByPhoneNumSrvc(String phoneNumber) throws ExceptionHandle;

	void deleteAccountSrvc(int accountId) throws ExceptionHandle;

	boolean checkUsername(String username) throws ExceptionHandle;

}
