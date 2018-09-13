package com.app.dao;

import com.app.model.Account;
import com.app.model.AccountPermission;

public interface AccountDao {
	Account registerAccountDao(Account account);

	Account loginAccountDao(Account account);

	Account findAccountByPhoneNumDao(String phoneNumber);

	void updatePasswordDao(int accountId, Account account);

	void updateAccountInfDao(int accountId, Account account);

	void deleteAccountDao(int accountId);

	AccountPermission savePermissionDao(AccountPermission permission);

	boolean checkAccount(Account account);

	AccountPermission getPermissionType(String permissionType);
}
