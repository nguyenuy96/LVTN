package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.WeightOfUsage;
import com.app.service.WeightService;

@CrossOrigin
@RestController
@RequestMapping(path = "/weight")
public class WeightController {

	@Autowired
	private WeightService weightService;

	@PostMapping
	public ResponseEntity<HttpStatus> addWeight(@RequestBody WeightOfUsage weightOfUsage) {
		weightService.saveWeight(weightOfUsage);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<WeightOfUsage>> getAllWeight() {
		return new ResponseEntity<>(weightService.listWeight(), HttpStatus.OK);
	}

	@GetMapping(path = "/{weightId}")
	public ResponseEntity<WeightOfUsage> getWeight(@PathVariable("weightId") Long weightId) {
		return new ResponseEntity<>(weightService.getWeight(weightId), HttpStatus.OK);
	}
}
