package com.app.service;

import com.app.dto.AccountDTO;
import com.app.dto.AccountReq;
import com.app.model.Account;
import com.app.dto.ModifiedPassword;

import java.util.List;

public interface AccountService {
	void addNewUser(AccountReq account);
	void changePassword(ModifiedPassword modifiedPassword);
	AccountDTO getAccountByUsername(String username);
	List<Account> findAllAccounts();
	void disableAccount(Long id);
}
