package com.app.dao;

import java.util.Optional;

import com.app.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {
	Optional<Country> findByCountryName(String countryName);
}
