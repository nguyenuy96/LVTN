package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductTypeDao;
import com.app.model.ProductionType;
import com.app.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	@Transactional
	@Override
	public void saveProductType(ProductionType productionType) {
		productTypeDao.save(productionType);
	}

	@Override
	public List<ProductionType> getProductTypes() {
		return productTypeDao.findAll();
	}

	@Override
	public ProductionType getProductType(Long productTypeId) {
		return productTypeDao.findById(productTypeId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Production type [%s] not found", productTypeId)));
	}
}
