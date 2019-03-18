package com.app.service;

import java.util.List;


import com.app.exception.ExceptionHandle;
import com.app.model.ListObject;
import com.app.model.Product;

public interface ProductService {
	void saveProduct(Product product) throws ExceptionHandle;

	List<Product> getAllProducts();

	ListObject listObject();
	
	void deleteProduct(int productId);
	
	List<Product> getProductByType(String productType);
	
}
