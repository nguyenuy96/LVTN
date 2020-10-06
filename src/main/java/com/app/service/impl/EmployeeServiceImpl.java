package com.app.service.impl;

import com.app.dao.AccountDao;
import com.app.dao.EmployeeDao;
import com.app.model.Account;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployee(String userName) {
        Account employeeAccount = accountDao.findByUserName(userName)
                .orElseThrow(() -> new IllegalArgumentException("Non-existed User"));
        return employeeDao.findById(employeeAccount.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Non-existed employee"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee updateEmployeeProfile(Employee request) {
        Employee employee = employeeDao.findById(request.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee"));
        employee.setAddress(request.getAddress());
        employee.setName(request.getName());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setGender(request.getGender());
        employee.setIdentification(request.getIdentification());
        employee.setNationality(request.getNationality());
        return employeeDao.save(employee);
    }
}
