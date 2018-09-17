package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		if (accountDao.checkAccount(account)) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed account!");
		}
		if (account.getPermission() == null || account.getUserLogin() == null || account.getPassword() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Please fill in all required fields!");
		}
		AccountPermission accountPermission = accountDao.getPermissionType(account.getPermission().getPermissionType());
		if (accountPermission == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permission type is incorrect!");
		}
		account.setPermission(accountPermission);
		account.setPassword(encrytePassword(account.getPassword()));
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
		AccountPermission retPermission = accountDao.getPermissionType(permission.getPermissionType());
		if (retPermission != null) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed permission!");
		}
		if (permission.getPermissionType() == null) {
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Permisstion type is required");
		}
		return accountDao.savePermissionDao(permission);
	}
	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}
