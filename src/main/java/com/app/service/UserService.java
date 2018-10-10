package com.app.service;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;

public interface UserService {

	Account accountDetailSrvc(Account account) throws ExceptionHandle;

	Account findAccountByPhoneNumSrvc(String phoneNumber) throws ExceptionHandle;

	void updatePasswordSrvc(Account account) throws ExceptionHandle;

	void deleteAccountSrvc(int accountId) throws ExceptionHandle;

	Role saveOrUpdateRoleSrvc(Role role) throws ExceptionHandle;

	List<Account> getCustomerAccount(int customerRole);

	List<Account> getEmployeeAccount(int employeeRole);

	boolean checkUsername(String username) throws ExceptionHandle;

	void saveUserSrvc(List<Object> lstUserProp) throws ExceptionHandle;

	void updateProfile(Object profile) throws ExceptionHandle;

	Customer getCusProfile(Account account);
}
