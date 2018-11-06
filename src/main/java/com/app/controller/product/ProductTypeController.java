package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ProductType;
import com.app.service.product.ProductTypeService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product-type")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProductType(@RequestBody ProductType productType) {
		productTypeService.saveProductType(productType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<ProductType>> getProductTypes() {
		List<ProductType> listProductType = productTypeService.getProductTypes();
		return new ResponseEntity<List<ProductType>>(listProductType, HttpStatus.OK);
	}
}
