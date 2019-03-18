package com.app.dao.impl.user;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.user.AccountDao;
import com.app.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	HibernateResult hibernate;

	@Override
	public Account checkAccountDao(String username) {
		Query<Account> query = hibernate.inputStringQuery(Account.class, "username", username);
		return (query.list().size() == 1) ? query.getSingleResult() : null;
	}

	@Override
	public Account findAccountByPhoneNumDao(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountDao(int accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyPassword(Account account) {
		hibernate.getSession().update(account);
	}

	@Override
	public void saveAccount(Account account) {
		String saltPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(saltPassword);
		hibernate.getSession().save(account);

	}

	@Override
	public Account getAccountById(int accountId) {
		Account account = hibernate.getById(Account.class, accountId);
		return account;
	}

}
