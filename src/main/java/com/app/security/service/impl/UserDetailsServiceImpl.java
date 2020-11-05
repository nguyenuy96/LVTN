package com.app.security.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.AccountDao;
import com.app.model.Account;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private final AccountDao accountDao;

	public UserDetailsServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDao.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User [%s] not found", username)));
		return new User(account.getUserName(), account.getPassword(), Collections.emptyList());
	}
}
