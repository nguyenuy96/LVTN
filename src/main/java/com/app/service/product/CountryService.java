package com.app.service.product;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Country;

public interface CountryService {
	void saveCountry(Country country) throws ExceptionHandle;

	List<Country> getCountries();

	Country getCountry(int countryId);
}
