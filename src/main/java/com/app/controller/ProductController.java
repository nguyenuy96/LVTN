package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.ListObject;
import com.app.model.Production;
import com.app.service.ProductService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
@RequestMapping(path = "/production")
public class ProductController {

	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<HttpStatus> addProduct(@Valid @NotNull @RequestBody Production production) {
		productService.addNewProduction(production);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<HttpStatus> modifyProduct(@RequestBody Object object) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Production>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping(path = "/listobject")
	public ResponseEntity<ListObject> getListObject() {
		return new ResponseEntity<>(productService.listObject(), HttpStatus.OK);
	}


	@GetMapping(path = "/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/productType")
	public ResponseEntity<List<Production>> getProductByType(@PathVariable(value = "productType") String productType) {
		return new ResponseEntity<>(productService.getProductByType(productType), HttpStatus.OK);
	}
}
