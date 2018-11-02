package com.app.dao.product;

import java.util.List;

import com.app.model.Country;

public interface CountryDao {

	void saveOrUpdateCountry(Country country);
	
	List<Country> listCountry();
	
	Country getCountry(int countryId);
}
