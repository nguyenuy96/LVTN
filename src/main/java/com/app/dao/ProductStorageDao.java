package com.app.dao;

import java.util.List;

import com.app.model.ProductStorageReception;

public interface ProductStorageDao {
	
	void saveProductStorage(ProductStorageReception productImport);
	
	List<ProductStorageReception> listProductStorage();
	
	ProductStorageReception getProductStorage(int productStorageId);
	
	List<ProductStorageReception> listProdStoreByProduct(int productId);

}
