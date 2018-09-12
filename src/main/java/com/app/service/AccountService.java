package com.app.service;

import com.app.model.Account;
import com.app.model.AccountPermission;

public interface AccountService {
	Account registerAccount(Account account);
	Account loginAccount(Account account);
	Account findAccountByPhoneNum(String phoneNumber);
	void updatePassword(int accountId, Account account);
	void updateAccountInf(int accountId, Account account);
	void deleteAccount(int accountId);
	AccountPermission savePermission(AccountPermission permission);
}
