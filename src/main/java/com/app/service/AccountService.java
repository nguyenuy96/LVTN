package com.app.service;

import com.app.model.Account;
import com.app.model.ModifiedPassword;

public interface AccountService {

	void addNewUser(Object userObj);

	void changePassword(ModifiedPassword modifiedPassword);

	Account getAccountByUsername(String username);

}
