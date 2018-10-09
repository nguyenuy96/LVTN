package com.app.service;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.model.Customer;

public interface AccountService {

	Account accountDetailSrvc(Account account) throws ExceptionHandle;

	Account findAccountByPhoneNumSrvc(String phoneNumber) throws ExceptionHandle;

	void updatePasswordSrvc(Account account) throws ExceptionHandle;

	void updateAccountInfSrvc(int accountId, Account account) throws ExceptionHandle;

	void deleteAccountSrvc(int accountId) throws ExceptionHandle;

	AccountPermission savePermissionSrvc(AccountPermission permission) throws ExceptionHandle;

	List<Account> getCustomerAccount(int customerRole);

	List<Account> getEmployeeAccount(int employeeRole);
	
	boolean checkUsername(String username) throws ExceptionHandle;

	void createUserSrvc(List<Object> lstUserProp) throws ExceptionHandle;
	
	Object updateProfile(Object profile);
	Customer getCusProfile(Account account);
}
