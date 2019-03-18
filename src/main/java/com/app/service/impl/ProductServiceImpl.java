package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.product.AgeDao;
import com.app.dao.product.CartDao;
import com.app.dao.product.ProductDao;
import com.app.dao.product.ProductTypeDao;
import com.app.dao.product.PromotionDao;
import com.app.dao.product.TradeMarkDao;
import com.app.dao.product.WarehouseDao;
import com.app.dao.product.WeightDao;
import com.app.exception.ExceptionHandle;
import com.app.exception.ExceptionThrower;
import com.app.model.ListObject;
import com.app.model.Product;
import com.app.model.CartDetail;
import com.app.service.ProductService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

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
	private CartDao cartDao;
	
	@Transactional
	@Override
	public void saveProduct(Product product) throws ExceptionHandle {
		String productName = product.getProductName();
		if(productName == null || productName == "" || productName == "null")
			new ExceptionThrower().throwException(HttpStatus.BAD_REQUEST, "Product name cannot be nul");
		boolean isExistedProduct = (productDao.findProductByName(productName) == null) ? false : true ;
		if(isExistedProduct)
			new ExceptionThrower().throwException(HttpStatus.CONFLICT, "Product name is duplicated");
		productDao.saveProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> listItem = productDao.listProduct();
		return listItem;
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
	public void deleteProduct(int productId) {
		Product product = productDao.getProduct(productId);
		CartDetail cartDetail = cartDao.getCartDetailByProductId(productId);
		if (cartDetail != null)
			cartDao.deleteCartDetail(cartDetail);
		productDao.deleteProduct(product);
	}

	@Override
	public List<Product> getProductByType(String productType) {
		List<Product> list = productDao.listProductByType(productType);
		return list;
	}

}
