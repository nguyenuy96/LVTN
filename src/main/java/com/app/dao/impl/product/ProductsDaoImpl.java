package com.app.dao.impl.product;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.ProductDao;
import com.app.model.Product;

@Repository
public class ProductsDaoImpl implements ProductDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveProduct(Product product) {
		hibernate.getSession().saveOrUpdate(product);
	}

	@Override
	public List<Product> listProduct() {
		List<Product> listProduct = hibernate.getResultList(Product.class);
		return listProduct;
	}

	@Override
	public Product getProduct(int productId) {
		Product product = hibernate.getById(Product.class, productId);
		return product;
	}

	public String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex < 0) {
			return null;
		}
		return fileName.substring(dotIndex + 1);
	}
	
	@Override
	public void deleteProduct(Product product) {
		hibernate.getSession().delete(product);
	}

	@Override
	public Product findProductByName(String productName) {
		Query<Product> query = hibernate.inputStringQuery(Product.class, "productName", productName);
		Product product = (query.list().size() == 0) ? null : query.getResultList().get(0);
		return product;
	}

	@Override
	public List<Product> listProductByType(String productType) {
		Query<Product> query = hibernate.inputStringQuery(Product.class, productType, productType);
		List<Product> list = (query.list().size() == 0) ? null : query.getResultList();
		return list;
	}
}
