package com.app.dao;

import java.util.List;

import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.model.Customer;
import com.app.model.Employee;

public interface AccountDao {
	Account registerAccountDao(Account account);

	Account findAccountByPhoneNumDao(String phoneNumber);

	AccountPermission savePermissionDao(AccountPermission permission);

	AccountPermission getPermissionType(String permissionType);

	Account checkAccountDao(String username);

	void updatePasswordDao(Account modifyAccount);

	void updateCusProfile(Customer customer);

	void udpateEmpProfile(Employee employee);

	Customer getCusProfile(int accId);

	Employee getEmpProfile(int accId);

	void deleteAccountDao(int accountId);

	List<Account> getCustomerAccount(int customerRole);

	List<Account> getEmployeeAccount(int EmployeeRole);

	void saveOrUpdateCusProf(Customer customer);

	void saveOrUpdateEmpProf(Employee employee);

	void saveOrUpdateAccount(Account account);
}
