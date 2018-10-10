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

	@Override
	public Account registerAccountDao(Account account) {
		Session session = sessionFactory.getCurrentSession();
		String saltPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(saltPassword);
		session.save(account);
		return account;
	}

	@Override
	public Account findAccountByPhoneNumDao(String phoneNumber) {
		return null;
	}

	@Override
	public void updatePasswordDao(Account modifiedAccount) {
		Session session = sessionFactory.getCurrentSession();
		String newPassword = bCryptPasswordEncoder.encode(modifiedAccount.getPassword());
		modifiedAccount.setPassword(newPassword);
		session.update(modifiedAccount);
	}

	@Override
	public void updateCusProfile(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public void udpateEmpProfile(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteAccountDao(int accountId) {

	}

	@Override
	public Role savePermissionDao(Role permission) {
		Session session = sessionFactory.getCurrentSession();
		session.save(permission);
		return permission;
	}

	@Override
	public Role getRole(String role) {
		// Session session = sessionFactory.getCurrentSession();
		// CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		// CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
		// Root<Role> root = criteriaQuery.from(Role.class);
		// criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("role"),
		// role));
		// Query<Role> query = session.createQuery(criteriaQuery);
		Query<Role> query = inputStringQuery(Role.class, "role", role);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	public <T> Query<T> inputStringQuery(Class<T> resultClass, String condition, String value) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = session.createQuery(criteriaQuery);
		return query;
	};

	public <T> Query<T> inputIntQuery(Class<T> resultClass, String condition, int value) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = session.createQuery(criteriaQuery);
		return query;
	};

	@Override
	public Account checkAccountDao(String username) {
		/*
		 * Session session = sessionFactory.getCurrentSession(); CriteriaQuery<Account>
		 * CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		 * CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		 * Root<Account> root = criteriaQuery.from(Account.class);
		 * criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"),
		 * username)); Query<Account> query = session.createQuery(criteriaQuery);
		 */

		Query<Account> query = inputStringQuery(Account.class, "username", username);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public List<Account> getCustomerAccount(int customerRole) {
		return getAccountByRole(customerRole);
	}

	@Override
	public List<Account> getEmployeeAccount(int employeeRole) {
		return getAccountByRole(employeeRole);
	}

	public List<Account> getAccountByRole(int roleId) {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
//		Root<Account> root = criteriaQuery.from(Account.class);
//		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("roleId"), roleId));
//		Query<Account> query = session.createQuery(criteriaQuery);
		Query<Account> query = inputIntQuery(Account.class, "roleId", roleId);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void saveAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		String saltPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(saltPassword);
		session.save(account);
	}

	@Transactional
	@Override
	public void saveOrUpdateEmpProf(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Transactional
	@Override
	public void saveOrUpdateCusProf(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCusProfile(int accId) {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//		Root<Customer> root = criteriaQuery.from(Customer.class);
//		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("accountId"), acctId));
//		Query<Customer> query = session.createQuery(criteriaQuery);
		Query<Customer> query = inputIntQuery(Customer.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public Employee getEmpProfile(int accId) {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
//		Root<Employee> root = criteriaQuery.from(Employee.class);
//		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("accountId"), accId));
//		Query<Employee> query = session.createQuery(criteriaQuery);
		Query<Employee> query = inputIntQuery(Employee.class, "accountId", accId);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

}
