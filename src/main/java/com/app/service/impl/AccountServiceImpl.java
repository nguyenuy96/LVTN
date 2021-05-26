package com.app.service.impl;


import com.app.dao.*;
import com.app.dto.AccountDTO;
import com.app.dto.AccountReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.Role;
import com.app.dto.ModifiedPassword;
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
	public void addNewUser(AccountReq request) {
		accountDao.findByUserName(request.getUserName()).ifPresent(e -> {
			throw new IllegalArgumentException("Existed user");
		});
		Account account = new Account();
		account.setUserName(request.getUserName());
		account.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		account.setRole(getRole(request.getRoleId()));
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
	public AccountDTO getAccountByUsername(String userName) {
		Account account = accountDao.findByUserName(userName)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Not found user [%s]", userName)));
		return account.convert2AccountDTO();
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

	public Role getRole(Long roleId) {
		return roleDao.findById(roleId).orElseThrow(() -> new IllegalArgumentException(
				String.format("Role with id = [%d] not found", roleId)));
	}
}
