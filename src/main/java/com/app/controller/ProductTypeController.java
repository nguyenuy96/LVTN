package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.ProductionType;
import com.app.service.ProductTypeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product-type")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@PostMapping
	public ResponseEntity<HttpStatus> addProductType(@RequestBody ProductionType productionType) {
		productTypeService.saveProductType(productionType);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ProductionType>> getProductTypes() {
		return new ResponseEntity<>(productTypeService.getProductTypes(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{productTypeId}")
	public ResponseEntity<ProductionType> getProductType(@PathVariable("productTypeId") Long productTypeId){
		return new ResponseEntity<>(productTypeService.getProductType(productTypeId), HttpStatus.OK);
	}
}
