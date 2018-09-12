package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccountDao;
import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.service.AccountService;
@Service
@Transactional(propagation = Propagation.SUPPORTS ,readOnly=true)
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	@Override
	public Account registerAccount(Account account) {
		Account accountSaved = accountDao.registerAccount(account);
		return accountSaved;
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

	@Transactional
	@Override
	public void updatePassword(int accountId, Account account) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void updateAccountInf(int accountId, Account account) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountPermission savePermission(AccountPermission permission) {
		AccountPermission permissionSaved = accountDao.savePermission(permission);
		return permissionSaved;
	}

}
