package com.app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.model.Account;
import com.app.model.Role;
import com.app.model.Customer;
import com.app.model.Employee;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// Query
	public <T> Query<T> inputStringQuery(Class<T> resultClass, String condition, String value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	};

	public <T> Query<T> inputIntQuery(Class<T> resultClass, String condition, int value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	};

	// Role
	@Override
	public Role savePermissionDao(Role permission) {
		getSession().save(permission);
		return permission;
	}

	@Override
	public List<Role> listRole() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
		Root<Role> root = criteriaQuery.from(Role.class);
		criteriaQuery.select(root);
		Query<Role> query = getSession().createQuery(criteriaQuery);
		List<Role> listRole = query.getResultList();
		return listRole;
	}

	@Override
	public Role getRole(String role) {
		Query<Role> query = inputStringQuery(Role.class, "role", role);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	// create user
	@Transactional
	@Override
	public void saveAccount(Account account) {
		String saltPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(saltPassword);
		getSession().save(account);
	}

	@Transactional
	@Override
	public void saveOrUpdateEmpProf(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	@Transactional
	@Override
	public void saveOrUpdateCusProf(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	// Modify user
	@Override
	public void modifyPassword(Account account) {
		getSession().update(account);
	}

	@Override
	public void updateCusProfile(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	@Override
	public void udpateEmpProfile(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	// get user by role


	// get customer
	@Override
	public List<Customer> getCustomerAccount() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		criteriaQuery.select(root);
		Query<Customer> query = getSession().createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public Customer getCusProfile(int accId) {
		Query<Customer> query = inputIntQuery(Customer.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	// get employee
	@Override
	public List<Employee> getEmployeeAccount() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);
		Query<Employee> query = getSession().createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public Employee getEmpProfile(int accId) {
		Query<Employee> query = inputIntQuery(Employee.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	// check
	@Override
	public Account checkAccountDao(String username) {
		Query<Account> query = inputStringQuery(Account.class, "username", username);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public boolean checkIdentification(String identification) {
		Query<Employee> empQuery = inputStringQuery(Employee.class, "identification", identification);
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
