package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.ProductTypeDao;
import com.app.model.ProductType;
import com.app.service.product.ProductTypeService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	@Transactional
	@Override
	public void saveProductType(ProductType productType) {
		productTypeDao.saveOrUpdateProductType(productType);
	}

	@Override
	public List<ProductType> getProductTypes() {
		List<ProductType> listProductType = productTypeDao.listProductType();
		return listProductType;
	}

}
