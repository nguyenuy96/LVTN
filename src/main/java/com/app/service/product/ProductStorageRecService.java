package com.app.service.product;

import java.util.List;

import com.app.model.ProductStorageReception;

public interface ProductStorageRecService {

	void saveProductStorageRec(ProductStorageReception productStorageReception);

	List<ProductStorageReception> listProductStorageRec(Long productId);

}
