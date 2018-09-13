package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccountDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Account;
import com.app.model.AccountPermission;
import com.app.service.AccountService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional
	@Override
	public Account registerAccountSrvc(Account account) throws ExceptionHandle {
		if (account.getPermission().getPermissionType().equals(null)) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Account permission is required!");
		}
		AccountPermission accountPermission = accountDao.getPermissionType(account.getPermission().getPermissionType());
		if (accountPermission == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permission type is incorrect!");
		}
		if (account.getUserLogin() == null || account.getPassword() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Username and password are required!");
		}
		if (accountDao.checkAccount(account)) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed account!");
		}
		account.setPermission(accountPermission);
		return accountDao.registerAccountDao(account);
	}

	@Override
	public Account loginAccountSrvc(Account account) throws ExceptionHandle {
		Account retAccount = accountDao.loginAccountDao(account);
		if (retAccount == null) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Invalid username or password!");
		}
		return retAccount;
	}

	@Override
	public Account findAccountByPhoneNumSrvc(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void updatePasswordSrvc(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void updateAccountInfSrvc(int accountId, Account account) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteAccountSrvc(int accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountPermission savePermissionSrvc(AccountPermission permission) throws ExceptionHandle {
		AccountPermission ret = accountDao.getPermissionType(permission.getPermissionType());
		if (ret != null) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed permission!");
		}
		if (permission.getPermissionType() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permisstion type is required");
		}
		return accountDao.savePermissionDao(permission);
	}

}
