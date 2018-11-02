package com.app.dao.user;

import com.app.model.Account;

public interface AccountDao {

	Account checkAccountDao(String username);

	Account findAccountByPhoneNumDao(String phoneNumber);

	void deleteAccountDao(int accountId);

	void modifyPassword(Account account);

	void saveAccount(Account account);
}
