package com.app.service;

import java.util.List;

import com.app.model.ProductionType;

public interface ProductTypeService {
	void saveProductType(ProductionType productionType);

	List<ProductionType> getProductTypes();
	
	ProductionType getProductType(Long productTypeId);
}
