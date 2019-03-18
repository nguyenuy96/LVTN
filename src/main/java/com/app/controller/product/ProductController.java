package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ListObject;
import com.app.model.Product;
import com.app.exception.ExceptionHandle;
import com.app.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Value("${upload.file.directory}")
	private String uploadDirectory;

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product) throws ExceptionHandle{
		productService.saveProduct(product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public ResponseEntity<HttpStatus> modifyProduct(@RequestBody Object object) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> listItem = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(listItem, HttpStatus.OK);
	}

	@RequestMapping(path = "/listobject", method = RequestMethod.GET)
	public ResponseEntity<ListObject> getListObject() {
		return new ResponseEntity<ListObject>(productService.listObject(), HttpStatus.OK);
	}


	@RequestMapping(path = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK); 
	}
	
	@RequestMapping(path = "/productType", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductByType(@PathVariable(value = "productType") String productType) {
		List<Product> list = productService.getProductByType(productType);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
}
