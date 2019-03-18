package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ExceptionHandle;
import com.app.model.Country;
import com.app.service.product.CountryService;

@CrossOrigin
@RestController
@RequestMapping(path = "/country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addCountry(@RequestBody Country country) throws ExceptionHandle{
		countryService.saveCountry(country);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getCountries() {
		List<Country> listCountry = countryService.getCountries();
		return new ResponseEntity<List<Country>>(listCountry, HttpStatus.OK);
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@RequestBody Country country) {
		Country country1 = countryService.getCountry(country.getCountryId());
		return new ResponseEntity<Country>(country1, HttpStatus.OK);
	}
}
