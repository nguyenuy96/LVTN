package com.app.dao;

import java.util.Optional;

import com.app.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long> {
	Optional<Contact> findByIdentification(String identification);
}
