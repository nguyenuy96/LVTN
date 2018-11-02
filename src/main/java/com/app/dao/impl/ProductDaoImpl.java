package com.app.dao.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ProductDao;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.Product;
import com.app.model.ProductStorageReceipt;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.Warehouse;
import com.app.model.TradeMark;
import com.app.model.Weight;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Value("${upload.file.extensions}")
	private String validExtensions;
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

	public String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex < 0) {
			return null;
		}
		return fileName.substring(dotIndex + 1);
	}

	@Override
	public void saveProduct(MultipartFile multipartFile, Product product, String uploadDirectory) {
		try {
			String imageName = product.getProductName() + "." + getFileExtension(multipartFile.getOriginalFilename());
			imageName = imageName.replaceAll("\\s", "_");
			Path path = Paths.get(uploadDirectory, imageName);
			Files.copy(multipartFile.getInputStream(), path);
			getSession().saveOrUpdate(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void saveProductStorage(ProductStorageReceipt productImport) {
		getSession().save(productImport);
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
	public Weight getWeightById(int weightId) {
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
	}

	@Override
	public List<ProductStorageReceipt> getProductImport() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<ProductStorageReceipt> criteriaQuery = criteriaBuilder.createQuery(ProductStorageReceipt.class);
		Root<ProductStorageReceipt> root = criteriaQuery.from(ProductStorageReceipt.class);
		criteriaQuery.select(root);
		Query<ProductStorageReceipt> query = getSession().createQuery(criteriaQuery);
		return query.getResultList();
	}

	public <T> List<T> getResultList(Class<T> resultClass) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root);
		Query<T> query = getSession().createQuery(criteriaQuery);
		List<T> list = query.getResultList();
		return list;
	}

	@Override
	public List<TradeMark> getAllLabel() {
		List<TradeMark> listLabel = getResultList(TradeMark.class);
		return listLabel;
	}

	@Override
	public List<ProductType> getAllProductType() {
		List<ProductType> listProductType = getResultList(ProductType.class);
		return listProductType;
	}

	@Override
	public List<Warehouse> getAllWarehouse() {
		List<Warehouse> listWarehouse = getResultList(Warehouse.class);
		return listWarehouse;
	};

	@Override
	public List<Promotion> getAllPromotion() {
		List<Promotion> listPromotion = getResultList(Promotion.class);
		return listPromotion;
	}
}
