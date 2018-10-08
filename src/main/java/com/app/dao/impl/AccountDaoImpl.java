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

import com.app.dao.AccountDao;
import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.model.Customer;
import com.app.model.Employee;

@Repository
public class AccountDaoImpl implements AccountDao {

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
	public Account accountDetailDao(Account account) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), account.getUsername()));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public Account findAccountByPhoneNumDao(String phoneNumber) {
		return null;
	}

	@Override
	public void updatePasswordDao(int accountId, Account account) {

	}

	@Override
	public void updateAccountInfDao(int accountId, Account account) {

	}

	@Override
	public void deleteAccountDao(int accountId) {

	}

	@Override
	public AccountPermission savePermissionDao(AccountPermission permission) {
		Session session = sessionFactory.getCurrentSession();
		session.save(permission);
		return permission;
	}

	@Override
	public boolean checkAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), account.getUsername()));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? true : false;
	}

	@Override
	public AccountPermission getPermissionType(String permissionType) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<AccountPermission> criteriaQuery = criteriaBuilder.createQuery(AccountPermission.class);
		Root<AccountPermission> root = criteriaQuery.from(AccountPermission.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("permissionType"), permissionType));
		Query<AccountPermission> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public Account findAccountByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public List<Account> getCustomerAccount(int customerRole) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("permissionId"), customerRole));
		Query<Account> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Account> getEmployeeAccount(int employeeRole) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("permissionId"), employeeRole));
		Query<Account> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void saveOrUpdateAccount(Account account) {
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
	public boolean checkUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? true : false;
	}

}
