package com.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public Account registerAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		return account;
	}

	@Override
	public Account loginAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountByPhoneNum(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountInf(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountPermission savePermission(AccountPermission permission) {
		Session session = sessionFactory.getCurrentSession();
		session.save(permission);
		return permission;
	}

}
