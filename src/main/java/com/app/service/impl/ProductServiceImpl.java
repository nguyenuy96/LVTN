package com.app.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.product.AgeDao;
import com.app.dao.product.CountryDao;
import com.app.dao.product.ImageDao;
import com.app.dao.product.ProductDao;
import com.app.dao.product.ProductStorageDao;
import com.app.dao.product.ProductTypeDao;
import com.app.dao.product.PromotionDao;
import com.app.dao.product.TradeMarkDao;
import com.app.dao.product.WarehouseDao;
import com.app.dao.product.WeightDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.Age;
import com.app.model.Country;
import com.app.model.ListObject;
import com.app.model.Product;
import com.app.model.ProductImage;
import com.app.model.ProductStorageReceipt;
import com.app.model.ProductType;
import com.app.model.Promotion;
import com.app.model.TradeMark;
import com.app.model.Warehouse;
import com.app.model.Weight;
import com.app.service.ProductService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductStorageDao productStorageDao;

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private TradeMarkDao tradeMarkDao;

	@Autowired
	private AgeDao ageDao;

	@Autowired
	private WeightDao weightDao;

	@Autowired
	private ProductTypeDao productTypeDao;

	@Autowired
	private PromotionDao promotionDao;

	@Autowired
	private WarehouseDao warehouseDao;

	@Autowired
	private ImageDao imageDao;

	@Transactional
	@Override
	public void saveProductStorage(ProductStorageReceipt productStorage) {
		productStorageDao.saveProductStorage(productStorage);
	}

	@Transactional
	@Override
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> listItem = productDao.listProduct();
		return listItem;
	}

	@Override
	public void saveOrUpdateCounrty(Country country) {
		String countryName = country.getCountryName().toLowerCase();
		char lowerChar = countryName.charAt(0);
		char upperChar = Character.toUpperCase(lowerChar);
		countryName = Character.toUpperCase(countryName.charAt(0)) + countryName.substring(1);
		String regex = "\\s";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(countryName);
		while (matcher.find()) {
			int index = matcher.end();
			lowerChar = countryName.charAt(index);
			upperChar = Character.toUpperCase(lowerChar);
			countryName = countryName.replace(lowerChar, upperChar);
		}
		country.setCountryName(countryName);
		countryDao.saveOrUpdateCountry(country);
	}

	@Override
	public void saveOrUpdateTradeMark(TradeMark tradeMark) throws ExceptionHandle {
		boolean isValidTradeMark = tradeMarkDao.isValidTradeMark(tradeMark.getTradeMark());
		if (isValidTradeMark) {
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Existed Label");
		}
		tradeMark.setTradeMark(tradeMark.getTradeMark().toUpperCase());
		tradeMarkDao.saveOrUpdateLabel(tradeMark);
	}

	@Transactional
	@Override
	public void saveAge(Age age) {
		ageDao.saveOrUpdateAge(age);
	}

	@Transactional
	@Override
	public void saveWeight(Weight weight) {
		weightDao.saveOrUpdateWeight(weight);
	}

	@Transactional
	@Override
	public void saveProductType(ProductType productType) {
		productTypeDao.saveOrUpdateProductType(productType);
	}

	@Override
	public List<ProductStorageReceipt> getStorageReceipt() {
		List<ProductStorageReceipt> productImports = productStorageDao.listProductStorage();
		return productImports;
	}

	@Override
	public ListObject listObject() {
		ListObject listObject = new ListObject();
		listObject.setProductTypes(productTypeDao.listProductType());
		listObject.setPromotions(promotionDao.listPromotion());
		listObject.setWarehouses(warehouseDao.listWarehouse());
		listObject.setTradeMarks(tradeMarkDao.listLabel());
		listObject.setAges(ageDao.listAge());
		listObject.setWeights(weightDao.listWeight());
		listObject.setWarehouses(warehouseDao.listWarehouse());
		return listObject;
	}

	@Transactional
	@Override
	public void savePromotion(Promotion promotion) {
		promotionDao.saveOrUpdatePromotion(promotion);
	}

	@Transactional
	@Override
	public void saveWarehouse(Warehouse warehouse) {
		warehouseDao.saveOrUpdateWarehouse(warehouse);
	}

	@Override
	public ProductImage saveImage(MultipartFile multipartFile, String uploadDirectory) {
		ProductImage image = imageDao.saveImage(multipartFile, uploadDirectory);
		return image;
	}

}
