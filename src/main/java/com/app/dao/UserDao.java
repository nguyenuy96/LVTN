package com.app.dao;

import java.util.List;

import com.app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Account, Long> {



//	void saveOrUpdateCusProf(Account account);

//	void saveOrUpdateEmpProf(Account account);

	// get customer
//	Customer getCusProfile(int accId);

//	List<Customer> getCustomerAccount();

	// get employee
//	Employee getEmpProfile(int accId);

//	List<Employee> getEmployeeAccount();


//	boolean checkIdentification(String identification);

	// other
//	Account findAccountByPhoneNumDao(String phoneNumber);

//	void deleteAccountDao(int accountId);

}
