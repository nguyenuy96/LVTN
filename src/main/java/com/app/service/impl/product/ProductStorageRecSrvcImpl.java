package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductStorageDao;
import com.app.model.ProductStorageReception;
import com.app.service.product.ProductStorageRecSrvc;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductStorageRecSrvcImpl implements ProductStorageRecSrvc{

	@Autowired
	private ProductStorageDao prodStorageDao;
	
	@Transactional
	@Override
	public void saveProductStorageRec(ProductStorageReception productStorageReception) {
		prodStorageDao.saveProductStorage(productStorageReception);
	}

	@Override
	public List<ProductStorageReception> listProductStorageRec(int productId) {
		List<ProductStorageReception> list = prodStorageDao.listProdStoreByProduct(productId);
		return list;
	}

}
