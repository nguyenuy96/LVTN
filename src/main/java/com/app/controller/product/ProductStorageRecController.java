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

import com.app.model.ProductStorageReceipt;
import com.app.service.product.ProductStorageRecSrvc;

@CrossOrigin
@RestController
@RequestMapping(path = "/storage")
public class ProductStorageRecController {

	@Autowired
	private ProductStorageRecSrvc prodStorageRecSrvc;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProStorageRec(@RequestBody ProductStorageReceipt productStorageReceipt) {
		prodStorageRecSrvc.saveProductStorageRec(productStorageReceipt);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list/{productId}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductStorageReceipt>> listProStorageRecByProduct(
			@PathVariable("productId") int productId) {
		List<ProductStorageReceipt> list = prodStorageRecSrvc.listProductStorageRec(productId);
		return new ResponseEntity<List<ProductStorageReceipt>>(list, HttpStatus.OK); 
	}

}
