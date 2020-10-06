package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductTypeDao;
import com.app.model.ProductType;
import com.app.service.product.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	@Transactional
	@Override
	public void saveProductType(ProductType productType) {
		productTypeDao.save(productType);
	}

	@Override
	public List<ProductType> getProductTypes() {
		return productTypeDao.findAll();
	}

	@Override
	public ProductType getProductType(Long productTypeId) {
		return productTypeDao.findById(productTypeId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Production type [%s] not found", productTypeId)));
	}
}
