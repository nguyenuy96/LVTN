package com.app.service.product;

import java.util.List;

import com.app.model.ProductStorageReceipt;

public interface ProductStorageRecSrvc {

	void saveProductStorageRec(ProductStorageReceipt productStorageReceipt);

	List<ProductStorageReceipt> listProductStorageRec(int productId);

}
