package com.app.service;

import com.app.exception.ExceptionHandle;
import com.app.model.Account;
import com.app.model.AccountPermission;

public interface AccountService {
	Account registerAccountSrvc(Account account) throws ExceptionHandle;

	Account accountDetailSrvc(Account account) throws ExceptionHandle;

	Account findAccountByPhoneNumSrvc(String phoneNumber) throws ExceptionHandle;

	void updatePasswordSrvc(int accountId, Account account) throws ExceptionHandle;

	void updateAccountInfSrvc(int accountId, Account account) throws ExceptionHandle;

	void deleteAccountSrvc(int accountId) throws ExceptionHandle;

	AccountPermission savePermissionSrvc(AccountPermission permission) throws ExceptionHandle;
	
}
