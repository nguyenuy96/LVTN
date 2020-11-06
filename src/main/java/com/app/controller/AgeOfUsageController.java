package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.AgeOfUsage;
import com.app.service.AgeService;

@RestController
@RequestMapping(path = "/age")
public class AgeOfUsageController {
	@Autowired
	private AgeService ageService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addAge(@RequestBody AgeOfUsage ageOfUsage) {
		ageService.saveAge(ageOfUsage);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgeOfUsage>> listAge() {
		List<AgeOfUsage> listAgeOfUsage = ageService.listAge();
		return new ResponseEntity<List<AgeOfUsage>>(listAgeOfUsage, HttpStatus.OK);
	}

	@RequestMapping(path = "/{ageId}", method = RequestMethod.GET)
	public ResponseEntity<AgeOfUsage> getAge(@PathVariable("ageId") Long ageId) {
		AgeOfUsage ageOfUsage = ageService.getAge(ageId);
		return new ResponseEntity<AgeOfUsage>(ageOfUsage, HttpStatus.OK);
	}

}
