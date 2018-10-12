package com.app.dao;

import java.util.List;

import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;
import com.app.model.Employee;

public interface UserDao {
	// Role
	Role savePermissionDao(Role permission);

	Role getRole(String role);

	// create an user
	void saveAccount(Account account);

	void saveOrUpdateCusProf(Customer customer);

	void saveOrUpdateEmpProf(Employee employee);

	// modify user

	void modifyPassword(Account account);

	void updateCusProfile(Customer customer);

	void udpateEmpProfile(Employee employee);

	// get customer
	Customer getCusProfile(int accId);

	List<Account> getCustomerAccount(int customerRole);

	// get employee
	Employee getEmpProfile(int accId);

	List<Account> getEmployeeAccount(int EmployeeRole);

	// check
	Account checkAccountDao(String username);

	boolean checkIdentification(String identification);

	// other
	Account findAccountByPhoneNumDao(String phoneNumber);

	void deleteAccountDao(int accountId);

}
