package com.app.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.Employee;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private HibernateResult hibernate;

	@Transactional
	@Override
	public void saveOrUpdateEmpProf(Account account) {
		Employee employee = account.getEmployee();
		getSession().saveOrUpdate(employee);
		getSession().save(account);
	}

	@Transactional
	@Override
	public void saveOrUpdateCusProf(Account account) {
		Customer customer = account.getCustomer();
		getSession().saveOrUpdate(customer);
		getSession().save(account);
	}


	@Override
	public void updateCusProfile(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	@Override
	public void udpateEmpProfile(Employee employee) {
		getSession().saveOrUpdate(employee);
	}


	// get customer
	@Override
	public List<Customer> getCustomerAccount() {
		List<Customer> listCustomer = hibernate.getResultList(Customer.class);
		return listCustomer;
	}

	@Override
	public Customer getCusProfile(int accId) {
		Query<Customer> query = hibernate.inputIntQuery(Customer.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	// get employee
	@Override
	public List<Employee> getEmployeeAccount() {
		List<Employee> employees = hibernate.getResultList(Employee.class);
		return employees;
	}

	@Override
	public Employee getEmpProfile(int accId) {
		Query<Employee> query = hibernate.inputIntQuery(Employee.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}


	@Override
	public boolean checkIdentification(String identification) {
		Query<Employee> empQuery = hibernate.inputStringQuery(Employee.class, "identification", identification);
		return (empQuery.list().size() == 1) ? true : false;
	}

	// other
	@Override
	public Account findAccountByPhoneNumDao(String phoneNumber) {
		return null;
	}

	@Override
	public void deleteAccountDao(int accountId) {

	}

}
