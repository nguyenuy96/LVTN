package com.app.dao.impl.product;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.ProductStorageDao;
import com.app.model.ProductStorageReception;

@Repository
public class ProductStorageDaoImpl implements ProductStorageDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveProductStorage(ProductStorageReception productImport) {
		String date = hibernate.getMySQLDate();
		productImport.setImportDate(date);
		hibernate.getSession().save(productImport);
	}

	@Override
	public List<ProductStorageReception> listProductStorage() {
		List<ProductStorageReception> listProductStorage = hibernate.getResultList(ProductStorageReception.class);
		return listProductStorage;
	}

	@Override
	public ProductStorageReception getProductStorage(int productStorageId) {
		ProductStorageReception productStorageReception = hibernate.getById(ProductStorageReception.class, productStorageId);
		return productStorageReception;
	}

	@Override
	public List<ProductStorageReception> listProdStoreByProduct(int productId) {
		Query<ProductStorageReception> query = hibernate.inputIntQuery(ProductStorageReception.class, "product", productId);
		List<ProductStorageReception> listProdStorageRec = query.getResultList();
		return listProdStorageRec;
	}

}
