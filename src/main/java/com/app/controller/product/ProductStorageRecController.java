package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.ProductStorageReception;
import com.app.service.product.ProductStorageRecService;

@CrossOrigin
@RestController
@RequestMapping(path = "/storage")
public class ProductStorageRecController {

	@Autowired
	private ProductStorageRecService productStorageRecService;

	@PostMapping
	public ResponseEntity<HttpStatus> saveProStorageRec(@RequestBody ProductStorageReception productStorageReception) {
		productStorageRecService.saveProductStorageRec(productStorageReception);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "/{productId}")
	public ResponseEntity<List<ProductStorageReception>> listProStorageRecByProduct(
			@PathVariable("productId") Long productId) {
		return new ResponseEntity<>(productStorageRecService.listProductStorageRec(productId), HttpStatus.OK);
	}

}
