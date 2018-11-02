package com.app.dao;

import java.util.List;

import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.Employee;

public interface UserDao {


	void saveOrUpdateCusProf(Account account);

	void saveOrUpdateEmpProf(Account account);


	void updateCusProfile(Customer customer);

	void udpateEmpProfile(Employee employee);

	// get customer
	Customer getCusProfile(int accId);

	List<Customer> getCustomerAccount();

	// get employee
	Employee getEmpProfile(int accId);

	List<Employee> getEmployeeAccount();


	boolean checkIdentification(String identification);

	// other
	Account findAccountByPhoneNumDao(String phoneNumber);

	void deleteAccountDao(int accountId);

}
