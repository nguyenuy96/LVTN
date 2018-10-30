package com.app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.ProductDao;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.Product;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.TradeMark;
import com.app.model.Weight;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Product> getAllProduct() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root);
		Query<Product> query = getSession().createQuery(criteriaQuery);
		List<Product> listItem = query.getResultList();
		return listItem;
	}

	@Override
	public void saveOrUpdate(Product product) {
		getSession().saveOrUpdate(product);
	}

	@Override
	public void saveOrUpdateCounrty(Country country) {
		getSession().saveOrUpdate(country);
	}

	@Override
	public void saveOrUpdateTradeMark(TradeMark tradeMark) {
		getSession().saveOrUpdate(tradeMark);
	}

	@Override
	public Country getCountry(String country) {
		Query<Country> query = inputStringQuery(Country.class, "countryName", country);
		Country country2 = (query.list().size() == 1) ? query.getSingleResult() : null;
		return country2;
	}

	@Override
	public boolean isValidTradeMark(String tradeMark) {
		Query<TradeMark> query = inputStringQuery(TradeMark.class, "tradeMark", tradeMark);
		boolean isValid = (query.list().size() == 1) ? true : false;
		return isValid;
	}

	public <T> Query<T> inputStringQuery(Class<T> resultClass, String condition, String value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	};

	public <T> Query<T> inputIntQuery(Class<T> resultClass, String condition, int value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	}

	@Override
	public TradeMark getLabel(int labelId) {
		TradeMark tradeMark = getSession().byId(TradeMark.class).load(labelId);
		return tradeMark;
	}

	@Override
	public Weight getWeight(int weightId) {
		Weight weight = getSession().byId(Weight.class).load(weightId);
		return weight;
	}

	@Override
	public Age getAge(int ageId) {
		Age age = getSession().byId(Age.class).load(ageId);
		return age;
	}

	@Override
	public ProductType getProductType(int productTypeId) {
		ProductType productType = getSession().byId(ProductType.class).load(productTypeId);
		return productType;
	}

	@Override
	public Promotion getPromotion(int promotionId) {
		Promotion promotion = getSession().byId(Promotion.class).load(promotionId);
		return promotion;
	}

	@Override
	public void saveWeight(Weight weight) {
		getSession().save(weight);
	}

	@Override
	public void saveAge(Age age) {
		getSession().save(age);
	}

	@Override
	public void saveProductType(ProductType productType) {
		getSession().save(productType);
	};
}
