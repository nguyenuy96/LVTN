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

import com.app.model.ProductStorageReception;
import com.app.service.product.ProductStorageRecSrvc;

@CrossOrigin
@RestController
@RequestMapping(path = "/storage")
public class ProductStorageRecController {

	@Autowired
	private ProductStorageRecSrvc prodStorageRecSrvc;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProStorageRec(@RequestBody ProductStorageReception productStorageReception) {
		prodStorageRecSrvc.saveProductStorageRec(productStorageReception);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductStorageReception>> listProStorageRecByProduct(
			@PathVariable("productId") int productId) {
		List<ProductStorageReception> list = prodStorageRecSrvc.listProductStorageRec(productId);
		return new ResponseEntity<List<ProductStorageReception>>(list, HttpStatus.OK);
	}

}
