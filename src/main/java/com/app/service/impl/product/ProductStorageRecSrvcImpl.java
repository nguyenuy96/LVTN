package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.ProductStorageDao;
import com.app.model.ProductStorageReceipt;
import com.app.service.product.ProductStorageRecSrvc;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductStorageRecSrvcImpl implements ProductStorageRecSrvc{

	@Autowired
	private ProductStorageDao prodStorageDao;
	
	@Transactional
	@Override
	public void saveProductStorageRec(ProductStorageReceipt productStorageReceipt) {
		prodStorageDao.saveProductStorage(productStorageReceipt);
	}

	@Override
	public List<ProductStorageReceipt> listProductStorageRec(int productId) {
		List<ProductStorageReceipt> list = prodStorageDao.listProdStoreByProduct(productId);
		return list;
	}

}
