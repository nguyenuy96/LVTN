package com.app.dao.product;

import java.util.List;

import com.app.model.ProductType;


public interface ProductTypeDao {
	
	void saveOrUpdateProductType(ProductType productType);

	List<ProductType> listProductType();

	ProductType getProductType(int productTypeId);
	
}
