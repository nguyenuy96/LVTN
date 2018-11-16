package com.app.dao.impl.product;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.ProductStorageDao;
import com.app.model.ProductStorageReceipt;

@Repository
public class ProductStorageDaoImpl implements ProductStorageDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveProductStorage(ProductStorageReceipt productImport) {
		String date = hibernate.getMySQLDate();
		productImport.setImportDate(date);
		hibernate.getSession().save(productImport);
	}

	@Override
	public List<ProductStorageReceipt> listProductStorage() {
		List<ProductStorageReceipt> listProductStorage = hibernate.getResultList(ProductStorageReceipt.class);
		return listProductStorage;
	}

	@Override
	public ProductStorageReceipt getProductStorage(int productStorageId) {
		ProductStorageReceipt productStorageReceipt = hibernate.getById(ProductStorageReceipt.class, productStorageId);
		return productStorageReceipt;
	}

	@Override
	public List<ProductStorageReceipt> listProdStoreByProduct(int productId) {
		Query<ProductStorageReceipt> query = hibernate.inputIntQuery(ProductStorageReceipt.class, "product", productId);
		List<ProductStorageReceipt> listProdStorageRec = query.getResultList();
		return listProdStorageRec;
	}

}
