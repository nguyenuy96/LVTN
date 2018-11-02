package com.app.dao.user;

import java.util.List;

import com.app.model.Customer;

public interface CustomerDao {
	
	void updateCusProfile(Customer customer);

	List<Customer> getCustomerAccount();

	Customer getCusProfile(int accId);
}
