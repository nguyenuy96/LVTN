package com.app.service;

import java.util.List;

import com.app.model.ListObject;
import com.app.model.Production;

public interface ProductService {
	void addNewProduction(Production production);

	List<Production> getAllProducts();

	ListObject listObject();
	
	void deleteProduct(Long productId);
	
	List<Production> getProductByType(String productType);
	
}
