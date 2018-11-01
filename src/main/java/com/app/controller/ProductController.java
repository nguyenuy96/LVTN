package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.exception.ExceptionHandle;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.Product;
import com.app.model.ProductStorage;
import com.app.model.ProductType;
import com.app.model.TradeMark;
import com.app.model.Weight;
import com.app.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/save-country", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addCountry(@RequestBody Country country) {
		productService.saveOrUpdateCounrty(country);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save-trademark", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addTradeMark(@RequestBody TradeMark tradeMark) throws ExceptionHandle {
		productService.saveOrUpdateTradeMark(tradeMark);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save-product", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<HttpStatus> addProduct(@RequestParam(value = "multipartFile") MultipartFile multipartFile,
			@ModelAttribute Product product) {
		productService.saveProduct(multipartFile, uploadDirectory, product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/product-storage", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProductStorage(@RequestBody ProductStorage productStorage) {
		productService.saveProductStorage(productStorage);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/productimport", method = RequestMethod.GET)
	public ResponseEntity<List<ProductStorage>> getProductImport() {
		return new ResponseEntity<List<ProductStorage>>(productService.getProductImport(), HttpStatus.OK);
	}

	@RequestMapping(path = "/list-product", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> listItem = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(listItem, HttpStatus.OK);
	}

	@RequestMapping(path = "/save-age", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addAge(@RequestBody Age age) {
		productService.saveAge(age);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save-weight", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addWeight(@RequestBody Weight weight) {
		productService.saveWeight(weight);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/save-product-type", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProductType(@RequestBody ProductType productType) {
		productService.saveProductType(productType);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
