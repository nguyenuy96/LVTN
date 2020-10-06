package com.app.dao.impl.user;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.impl.HibernateResult;
import com.app.dao.EmployeeDao;
import com.app.model.Employee;

public class EmployeeDaoImpl {
//
//	@Autowired
//	private HibernateResult hibernate;
//
//	@Override
//	public Employee getEmpProfile(int accId) {
//		Query<Employee> query = hibernate.inputIntQuery(Employee.class, "accountId", accId);
//		return (query.list().size() == 1) ? query.getSingleResult() : null;
//	}
//
//	@Override
//	public List<Employee> getEmployeeAccount() {
//		List<Employee> employees = hibernate.getResultList(Employee.class);
//		return employees;
//	}
//
//	@Override
//	public void udpateEmpProfile(Employee employee) {
//		hibernate.getSession().saveOrUpdate(employee);
//
//	}
//
//	@Override
//	public boolean checkIdentification(String identification) {
//		Query<Employee> empQuery = hibernate.inputStringQuery(Employee.class, "identification", identification);
//		return (empQuery.list().size() == 1) ? true : false;
//	}

}
