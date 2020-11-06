package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.model.Country;
import com.app.service.CountryService;

@RestController
@RequestMapping(path = "/country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addCountry(@RequestBody Country country) {
		countryService.saveCountry(country);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Country> getCountries() {
		return countryService.getCountries();
	}

	@GetMapping(path = "/{countryId}")
	@ResponseStatus(HttpStatus.OK)
	public Country getCountry(@PathVariable Long countryId) {
		return countryService.getCountry(countryId);
	}
}
