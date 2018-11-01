package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.exception.ExceptionHandle;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.Product;
import com.app.model.ProductStorage;
import com.app.model.ProductType;
import com.app.model.TradeMark;
import com.app.model.Weight;

public interface ProductService {
	void saveProduct(MultipartFile multipartFile, String uploadDirectory, Product product);
	
	void saveProductStorage(ProductStorage productStorage);

	List<Product> getAllProducts();

	void saveOrUpdateCounrty(Country country);

	void saveOrUpdateTradeMark(TradeMark tradeMark) throws ExceptionHandle;

	void saveAge(Age age);
	
	void saveWeight(Weight weight);
	
	void saveProductType(ProductType productType);
	
	List<ProductStorage> getProductImport();
}
