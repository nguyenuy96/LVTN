package com.app.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.model.Age;
import com.app.model.Country;
import com.app.model.ProductStorage;
import com.app.model.Product;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.TradeMark;
import com.app.model.Weight;

public interface ProductDao {
	List<Product> getAllProduct();
	
	void saveProductStorage(ProductStorage productImport);
	
	void saveProduct(MultipartFile multipartFile, Product product, String uploadDirectory);
	
	void saveOrUpdateCounrty(Country country);
	
	void saveOrUpdateTradeMark(TradeMark tradeMark);
	
	Country getCountry(String country);
	
	boolean isValidTradeMark(String tradeMark);
	
	TradeMark getLabel(int labelId);
	
	Weight getWeightById(int weightId);
	
	Age getAge(int ageId);
	
	ProductType getProductType(int productTypeId);
	
	Promotion getPromotion(int promotionId);
	
	void saveWeight(Weight weight);
	
	void saveAge(Age age);
	
	void saveProductType(ProductType productType);
	
	List<ProductStorage> getProductImport();
	
}
