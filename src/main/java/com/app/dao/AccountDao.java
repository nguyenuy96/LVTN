package com.app.dao;

import java.util.List;

import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.model.Customer;
import com.app.model.Employee;

public interface AccountDao {
	Account registerAccountDao(Account account);

	Account accountDetailDao(Account account);

	Account findAccountByPhoneNumDao(String phoneNumber);

	void updatePasswordDao(int accountId, Account account);

	void updateAccountInfDao(int accountId, Account account);

	void deleteAccountDao(int accountId);

	AccountPermission savePermissionDao(AccountPermission permission);

	boolean checkAccount(Account account);

	AccountPermission getPermissionType(String permissionType);

	Account findAccountByUsername(String username);

	List<Account> getCustomerAccount(int customerRole);

	List<Account> getEmployeeAccount(int EmployeeRole);
	
	boolean checkUsername(String username);
	void saveOrUpdateCusProf(Customer customer);
	void saveOrUpdateEmpProf(Employee employee);
	void saveOrUpdateAccount(Account account);
}
