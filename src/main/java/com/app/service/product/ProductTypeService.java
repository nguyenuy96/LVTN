package com.app.service.product;

import java.util.List;

import com.app.model.ProductType;

public interface ProductTypeService {
	void saveProductType(ProductType productType);

	List<ProductType> getProductTypes();
	
	ProductType getProductType(Long productTypeId);
}
