package com.app.service.product;

import java.util.List;

import com.app.model.Country;

public interface CountryService {
	void saveCountry(Country country);

	List<Country> getCountries();

	Country getCountry(int countryId);
}
