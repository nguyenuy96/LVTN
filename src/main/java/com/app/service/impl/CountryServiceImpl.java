package com.app.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CountryDao;
import com.app.model.Country;
import com.app.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	public void saveCountry(Country country) {
		String countryName = country.getCountryName();
		countryDao.findByCountryName(countryName)
				.ifPresent(e -> {
					throw new IllegalArgumentException("Existed country");
				});
		countryName = country.getCountryName().toLowerCase();
		countryName = Character.toUpperCase(countryName.charAt(0)) + countryName.substring(1);
		String regex = "\\s";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(countryName);
		while (matcher.find()) {
			int index = matcher.end();
			char lowerChar = countryName.charAt(index);
			char upperChar = Character.toUpperCase(lowerChar);
			countryName = countryName.replace(lowerChar, upperChar);
		}
		country.setCountryName(countryName);
		countryDao.save(country);
	}

	@Override
	public List<Country> getCountries() {
		return countryDao.findAll();
	}

	@Override
	public Country getCountry(Long countryId) {
		return countryDao.findById(countryId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Not found country with id [%d]", countryId)));
	}

}
