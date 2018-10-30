package com.app.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.Product;
import com.app.model.ProductType;
import com.app.model.TradeMark;
import com.app.model.Weight;
import com.app.service.ProductService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public void saveOrUpdate(Product product) {
//		TradeMark tradeMark = productDao.getLabel(product.getAge().getAgeId());
//		Weight weight = productDao.getWeight(product.getWeight().getWeightId());
//		Age age = productDao.getAge(product.getAge().getAgeId());
//		ProductType productType = productDao.getProductType(product.getProductType().getProductTypeId());
//		product.setTradeMark(tradeMark);;
//		product.setWeight(weight);
//		product.setAge(age);
//		product.setProductType(productType);
		productDao.saveOrUpdate(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> listItem = productDao.getAllProduct();
		return listItem;
	}

	@Override
	public void saveOrUpdateCounrty(Country country) {
		String countryName = country.getCountryName().toLowerCase();
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
		productDao.saveOrUpdateCounrty(country);
	}

	@Override
	public void saveOrUpdateTradeMark(TradeMark tradeMark) throws ExceptionHandle {
		boolean isValidTradeMark = productDao.isValidTradeMark(tradeMark.getTradeMark());
		if (isValidTradeMark) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed Label");
		}
		String countryName = tradeMark.getCountry().getCountryName();
		Country country = productDao.getCountry(countryName);
		boolean isValidCountry = (country == null) ? false : true;
		if (!isValidCountry) {
			new ExceptionThrower().throwException(HttpStatus.NOT_FOUND, "Invalid country!");
		}
		tradeMark.setCountry(country);
		tradeMark.setTradeMark(tradeMark.getTradeMark().toUpperCase());
		productDao.saveOrUpdateTradeMark(tradeMark);
	}

	@Override
	public void saveAge(Age age) {
		productDao.saveAge(age);
	}

	@Override
	public void saveWeight(Weight weight) {
		productDao.saveWeight(weight);
	}

	@Override
	public void saveProductType(ProductType productType) {
		productDao.saveProductType(productType);
	}

}
