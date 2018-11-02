package com.app.dao.product;

import java.util.List;

import com.app.model.Product;

public interface ProductDao {
	
	void saveProduct(Product product);

	List<Product> listProduct();

	Product getProduct(int productId);

}
