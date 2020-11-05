package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Country;
import com.app.service.CountryService;

@CrossOrigin
@RestController
@RequestMapping(path = "/country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addCountry(@RequestBody Country country) {
		countryService.saveCountry(country);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getCountries() {
		return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@RequestBody Country country) {
		return new ResponseEntity<>(countryService.getCountry(country.getCountryId()), HttpStatus.OK);
	}
}
