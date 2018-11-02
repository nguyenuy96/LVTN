package com.app.dao.product;

import java.util.List;

import com.app.model.ProductStorageReceipt;

public interface ProductStorageDao {
	
	void saveProductStorage(ProductStorageReceipt productImport);
	
	List<ProductStorageReceipt> listProductStorage();
	
	ProductStorageReceipt getProductStorage(int productStorageId);

}
