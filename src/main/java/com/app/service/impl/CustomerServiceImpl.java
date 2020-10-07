package com.app.service.impl;

import com.app.dao.AccountDao;
import com.app.dao.CustomerDao;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomer(String userName) {
        Account cusAcc = accountDao.findByUserName(userName)
                .orElseThrow(() -> new IllegalArgumentException("Non-existed User"));
        return customerDao.findById(cusAcc.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Non-existed customer"));
    }

    @Override
    public List<Customer> getAllCustomers() {
		return customerDao.findAll();
    }

    @Override
    public Customer updateCustomer(Customer request) {
        Customer customer = customerDao.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer"));
        customer.setAddress(request.getAddress());
        customer.setName(request.getName());
        customer.setPhoneNumber(request.getPhoneNumber());
        return customerDao.save(customer);
    }
}
