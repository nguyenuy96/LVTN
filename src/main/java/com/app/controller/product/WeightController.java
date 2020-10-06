package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Weight;
import com.app.service.product.WeightService;

@CrossOrigin
@RestController
@RequestMapping(path = "/weight")
public class WeightController {

	@Autowired
	private WeightService weightService;

	@PostMapping
	public ResponseEntity<HttpStatus> addWeight(@RequestBody Weight weight) {
		weightService.saveWeight(weight);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Weight>> getAllWeight() {
		return new ResponseEntity<>(weightService.listWeight(), HttpStatus.OK);
	}

	@GetMapping(path = "/{weightId}")
	public ResponseEntity<Weight> getWeight(@PathVariable("weightId") Long weightId) {
		return new ResponseEntity<>(weightService.getWeight(weightId), HttpStatus.OK);
	}
}
