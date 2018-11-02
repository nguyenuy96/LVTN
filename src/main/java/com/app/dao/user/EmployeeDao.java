package com.app.dao.user;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeDao {

	Employee getEmpProfile(int accId);

	List<Employee> getEmployeeAccount();

	void udpateEmpProfile(Employee employee);

	boolean checkIdentification(String identification);

}
