package com.app.service;

import com.app.model.Account;
import com.app.model.ModifiedPassword;

import java.util.List;

public interface AccountService {

	void addNewUser(Account account);

	void changePassword(ModifiedPassword modifiedPassword);

	Account getAccountByUsername(String username);

	List<Account> findAllAccounts();

}
