package com.app.dao.impl.product;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.CountryDao;
import com.app.model.Country;
@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateCountry(Country country) {
		hibernate.getSession().saveOrUpdate(country);
	}

	@Override
	public List<Country> listCountry() {
		List<Country> listCountry = hibernate.getResultList(Country.class);
		return listCountry;
	}

	@Override
	public Country getCountry(int countryId) {
		Country country = hibernate.getById(Country.class, countryId);
		return country;
	}

	@Override
	public Country findCountryByName(String countryName) {
		Query<Country> query = hibernate.inputStringQuery(Country.class, "countryName", countryName);
		Country country = (query.list().size() == 0) ? null : query.getResultList().get(0);
		return country;
	}

}
