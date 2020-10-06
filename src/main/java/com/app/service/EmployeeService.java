package com.app.service;

import com.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(String userName);
    List<Employee> getAllEmployee();
    Employee updateEmployeeProfile(Employee request);
}
