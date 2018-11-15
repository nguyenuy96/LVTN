package com.app.dao.impl.product;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.ProductTypeDao;
import com.app.model.ProductType;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateProductType(ProductType productType) {
		hibernate.getSession().saveOrUpdate(productType);
	}

	@Override
	public List<ProductType> listProductType() {
		List<ProductType> listProductType = hibernate.getResultList(ProductType.class);
		return listProductType;
	}

	@Override
	public ProductType getProductType(int productTypeId) {
		ProductType productType = hibernate.getById(ProductType.class, productTypeId);
		return productType;
	}

	@Override
	public ProductType getProductTypeValue(String value) {
		Query<ProductType> query = hibernate.inputStringQuery(ProductType.class,"productType", value);
		ProductType productTypeValue = query.getSingleResult();
		return productTypeValue;
	}

}
