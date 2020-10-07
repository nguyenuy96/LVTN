package com.app.controller.product;

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

import com.app.model.Age;
import com.app.service.product.AgeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/age")
public class AgeController {
	@Autowired
	private AgeService ageService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addAge(@RequestBody Age age) {
		ageService.saveAge(age);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Age>> listAge() {
		List<Age> listAge = ageService.listAge();
		return new ResponseEntity<List<Age>>(listAge, HttpStatus.OK);
	}

	@RequestMapping(path = "/{ageId}", method = RequestMethod.GET)
	public ResponseEntity<Age> getAge(@PathVariable("ageId") Long ageId) {
		Age age = ageService.getAge(ageId);
		return new ResponseEntity<Age>(age, HttpStatus.OK);
	}

}
