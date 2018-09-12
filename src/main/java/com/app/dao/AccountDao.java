package com.app.dao;

import com.app.model.Account;
import com.app.model.AccountPermission;

public interface AccountDao {
	Account registerAccount(Account account);
	Account loginAccount(Account account);
	Account findAccountByPhoneNum(String phoneNumber);
	void updatePassword(int accountId, Account account);
	void updateAccountInf(int accountId, Account account);
	void deleteAccount(int accountId);
	AccountPermission savePermission(AccountPermission permission);
}
