package com.app.service;

import com.app.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String userName);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer request);
}
