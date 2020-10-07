package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/{userName}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String userName) {
        return new ResponseEntity<>(customerService.getCustomer(userName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> customerAccount() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }
}
