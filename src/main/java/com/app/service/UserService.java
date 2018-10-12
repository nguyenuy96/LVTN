package com.app.service;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;
import com.app.model.ModifyPassword;

public interface UserService {

	// role
	Role saveOrUpdateRoleSrvc(Role role) throws ExceptionHandle;

	// create user
	void saveUserSrvc(List<Object> lstUserProp) throws ExceptionHandle;

	void registerUserSrvc(Customer customer) throws ExceptionHandle;

	// modify user
	void modifyPasswordSrvc(ModifyPassword modifyPassword) throws ExceptionHandle;

	void updateProfile(Object profile) throws ExceptionHandle;

	// get user
	List<Account> getCustomerAccount(int customerRole);

	List<Account> getEmployeeAccount(int employeeRole);

	Customer getCusProfile(Account account);

	Account accountDetailSrvc(Account account) throws ExceptionHandle;

	// other
	Account findAccountByPhoneNumSrvc(String phoneNumber) throws ExceptionHandle;

	void deleteAccountSrvc(int accountId) throws ExceptionHandle;

	boolean checkUsername(String username) throws ExceptionHandle;

}
