package com.app.service.impl;


import com.app.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.Role;
import com.app.model.ModifiedPassword;
import com.app.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void addNewUser(Account account) {
		validateAccount(account);
		accountDao.save(account);
	}

	@Override
	public void changePassword(ModifiedPassword modifiedPassword) {
		Account modifiedAccount = accountDao.findByUserName(modifiedPassword.getUserName())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user"));
		if (!bCryptPasswordEncoder.matches(modifiedPassword.getOldPassword(), modifiedAccount.getPassword())) {
			throw new IllegalArgumentException("Incorrect old password");
		}

		if (!modifiedPassword.getNewPassword().equals(modifiedPassword.getRetypePassword())) {
			throw new IllegalArgumentException("New password and re-type are not matched");
		}
		modifiedAccount.setPassword(bCryptPasswordEncoder.encode(modifiedPassword.getNewPassword()));
		accountDao.save(modifiedAccount);
	}

	@Override
	public Account getAccountByUsername(String userName) {
		return accountDao.findByUserName(userName)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Not found user [%s]", userName)));
	}

	@Override
	public List<Account> findAllAccounts() {
		return accountDao.findAll();
	}

	@Override
	public void disableAccount(Long id) {
		Account account = accountDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Not found user with id [%d]", id)));
		account.setActive(false);
		accountDao.save(account);
	}

	public Role getRole(Role role) {
		String roleName = role.getRoleName();
		if (roleName == null) {
			throw new IllegalArgumentException("Role is required!");
		}
		return roleDao.findByRoleName(roleName).orElseThrow(() -> new IllegalArgumentException(
				String.format("Role [%s] not found", roleName)));
	}

	public void validateAccount(Account account) {
		String userName = account.getUserName();
		if(userName == null) {
			throw new IllegalArgumentException("Username is required");
		}

		String password = account.getPassword();
		if(password == null) {
			throw new IllegalArgumentException("Password is required");
		}

		accountDao.findByUserName(userName).ifPresent(e -> {
			throw new IllegalArgumentException("Existed user");
		});
		account.setPassword(bCryptPasswordEncoder.encode(password));
		account.setRole(getRole(account.getRole()));
	}
}
