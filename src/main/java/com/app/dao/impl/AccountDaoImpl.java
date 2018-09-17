package com.app.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.AccountDao;
import com.app.model.Account;
import com.app.model.AccountPermission;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account registerAccountDao(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		return account;
	}

	@Override
	public Account loginAccountDao(Account account) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root)
				.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("userLogin"), account.getUserLogin()),
						criteriaBuilder.equal(root.get("password"), account.getPassword())));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public Account findAccountByPhoneNumDao(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePasswordDao(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountInfDao(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccountDao(int accountId) {
		// TODO Auto-generated method stub

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
		criteriaQuery.select(root)
				.where(criteriaBuilder.equal(root.get("userLogin"), account.getUserLogin()));
		Query<Account> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? true : false;
	}

	@Override
	public AccountPermission getPermissionType(String permissionType) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<AccountPermission> criteriaQuery = criteriaBuilder.createQuery(AccountPermission.class);
		Root<AccountPermission> root = criteriaQuery.from(AccountPermission.class);
		criteriaQuery.select(root)
				.where(criteriaBuilder.equal(root.get("permissionType"), permissionType));
		Query<AccountPermission> query = session.createQuery(criteriaQuery);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}
	

}
