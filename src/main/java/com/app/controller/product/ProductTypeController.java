package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.ProductType;
import com.app.service.product.ProductTypeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product-type")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@PostMapping
	public ResponseEntity<HttpStatus> addProductType(@RequestBody ProductType productType) {
		productTypeService.saveProductType(productType);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ProductType>> getProductTypes() {
		return new ResponseEntity<>(productTypeService.getProductTypes(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{productTypeId}")
	public ResponseEntity<ProductType> getProductType(@PathVariable("productTypeId") Long productTypeId){
		return new ResponseEntity<>(productTypeService.getProductType(productTypeId), HttpStatus.OK);
	}
}
