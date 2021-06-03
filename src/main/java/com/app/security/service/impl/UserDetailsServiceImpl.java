package com.app.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.app.model.Privilege;
import com.app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

		List<Role> list = new ArrayList<>();
		list.add(account.getRole());
		Collection<Role> roleCollection = new ArrayList<>(list);

		return new User(account.getUserName(), account.getPassword(), getAuthorities(roleCollection));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(
			Collection<Role> roles) {

		return getGrantedAuthorities(getPrivileges(roles));
	}

	private List<String> getPrivileges(Collection<Role> roles) {

		List<String> privileges = new ArrayList<>();
		List<Privilege> collection = new ArrayList<>();
		for (Role role : roles) {
			collection.add(role.getPrivilege());
		}
		for (Privilege item : collection) {
			privileges.add(item.getName());
		}
		return privileges;
	}

	private List<SimpleGrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}
}
