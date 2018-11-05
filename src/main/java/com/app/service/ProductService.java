package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.exception.ExceptionHandle;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.ListObject;
import com.app.model.Product;
import com.app.model.ProductExportReceipt;
import com.app.model.ProductImage;
import com.app.model.ProductStorageReceipt;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.TradeMark;
import com.app.model.Warehouse;
import com.app.model.Weight;

public interface ProductService {
	void saveProduct(Product product);

	void saveProductStorage(ProductStorageReceipt productStorage);
	
	void saveProdcutExport(ProductExportReceipt productExportReceipt);

	List<Product> getAllProducts();

	void saveOrUpdateCounrty(Country country);

	void saveOrUpdateTradeMark(TradeMark tradeMark) throws ExceptionHandle;

	void saveAge(Age age);

	void saveWeight(Weight weight);

	void saveProductType(ProductType productType);

	void savePromotion(Promotion promotion);

	void saveWarehouse(Warehouse warehouse);

	List<ProductStorageReceipt> getStorageReceipt();
	
	List<ProductExportReceipt> getProductExportReceipt();

	ListObject listObject();
	
	ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory);
}
