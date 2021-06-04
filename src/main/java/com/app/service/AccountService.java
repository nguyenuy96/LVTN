package com.app.service;

import com.app.dto.AccountDTO;
import com.app.dto.CreatedAccount;
import com.app.dto.ResponseAccount;
import com.app.model.Account;
import com.app.dto.ModifiedPassword;

import java.util.List;

public interface AccountService {
	void addNewUser(CreatedAccount account);
	void changePassword(ModifiedPassword modifiedPassword);
	ResponseAccount getAccountByUsername(String username);
	List<ResponseAccount> findAllAccounts();
	void disableAccount(Long id);
}
