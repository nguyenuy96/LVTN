package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AgeOfUsage;
import com.app.service.AgeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/age")
public class AgeController {
	@Autowired
	private AgeService ageService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addAge(@RequestBody AgeOfUsage ageOfUsage) {
		ageService.saveAge(ageOfUsage);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
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
