package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CountryDao;
import com.app.model.Country;
import com.app.service.product.CountryService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	public void saveCountry(Country country) {
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
