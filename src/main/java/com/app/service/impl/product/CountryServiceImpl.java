package com.app.service.impl.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CountryDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Country;
import com.app.service.product.CountryService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	public void saveCountry(Country country) throws ExceptionHandle {
		boolean isExistedCountry = (countryDao.findCountryByName(country.getCountryName()) == null) ? false : true;
		String countryName = country.getCountryName();
		if (countryName == null || countryName == "null" || countryName == "")
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Country name can not be null!");
		if (isExistedCountry)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "This is an existed country");
		countryName = country.getCountryName().toLowerCase();
		char lowerChar = countryName.charAt(0);
		char upperChar = Character.toUpperCase(lowerChar);
		countryName = Character.toUpperCase(countryName.charAt(0)) + countryName.substring(1);
		String regex = "\\s";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(countryName);
		while (matcher.find()) {
			int index = matcher.end();
			lowerChar = countryName.charAt(index);
			upperChar = Character.toUpperCase(lowerChar);
			countryName = countryName.replace(lowerChar, upperChar);
		}
		country.setCountryName(countryName);
		countryDao.saveOrUpdateCountry(country);
	}

	@Override
	public List<Country> getCountries() {
		List<Country> listCountry = countryDao.listCountry();
		return listCountry;
	}

	@Override
	public Country getCountry(int countryId) {
		Country country = countryDao.getCountry(countryId);
		return country;
	}

}
