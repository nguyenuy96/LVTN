package com.app.dao;

import com.app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

	Optional<Account> findByUserName(String userName);
	Account checkAccountDao(String username);
}
