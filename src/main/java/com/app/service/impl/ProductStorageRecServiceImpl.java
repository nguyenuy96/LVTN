package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductStorageDao;
import com.app.model.ProductStorageReception;
import com.app.service.ProductStorageRecService;

@Service
public class ProductStorageRecServiceImpl implements ProductStorageRecService {

	@Autowired
	private ProductStorageDao productStorageDao;
	
	@Transactional
	@Override
	public void saveProductStorageRec(ProductStorageReception productStorageReception) {
		productStorageDao.save(productStorageReception);
	}

	@Override
	public List<ProductStorageReception> listProductStorageRec(Long productId) {
		return productStorageDao.findAllByProduction(productId);
	}

}
