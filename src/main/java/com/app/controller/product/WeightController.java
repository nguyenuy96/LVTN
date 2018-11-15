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

import com.app.model.Weight;
import com.app.service.product.WeightService;

@CrossOrigin
@RestController
@RequestMapping(path = "/weight")
public class WeightController {

	@Autowired
	private WeightService weightService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addWeight(@RequestBody Weight weight) {
		weightService.saveWeight(weight);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Weight>> listWeight() {
		List<Weight> listWeight = weightService.listWeight();
		return new ResponseEntity<List<Weight>>(listWeight, HttpStatus.OK);
	}

	@RequestMapping(path = "/get/{weightId}", method = RequestMethod.GET)
	public ResponseEntity<Weight> getWeight(@PathVariable("weightId") int weightId) {
		Weight weight = weightService.getWeight(weightId);
		return new ResponseEntity<Weight>(weight, HttpStatus.OK);
	}

}
