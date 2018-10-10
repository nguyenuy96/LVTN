package com.app.security.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.impl.UserDaoImpl;
import com.app.model.Account;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDaoImpl userDaoImpl;

	public UserDetailsServiceImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account retAccount = userDaoImpl.checkAccountDao(username);
		if (retAccount == null) {
			throw new UsernameNotFoundException("Not found user" + username);
		}
		return new User(retAccount.getUsername(), retAccount.getPassword(), Collections.emptyList());
	}
}
