package com.app.service.impl;

import java.util.List;

import com.app.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import com.app.model.ListObject;
import com.app.model.Production;
import com.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductionDao productionDao;

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

	@Autowired
	private CartDetailDao cartDetailDao;

	@Override
	public void addNewProduction(Production production) {
		String productName = production.getProductionName();
		productionDao.findByProductionName(productName).ifPresent(e -> {
			throw new IllegalArgumentException("Production is already existed");
		});
		productionDao.save(production);
	}

	@Override
	public List<Production> getAllProducts() {
		return productionDao.findAll();
	}


	@Override
	public ListObject listObject() {
		ListObject listObject = new ListObject();
		listObject.setProductionTypes(productTypeDao.findAll());
		listObject.setPromotions(promotionDao.findAll());
		listObject.setWarehouses(warehouseDao.findAll());
		listObject.setTradeMarks(tradeMarkDao.findAll());
		listObject.setAgeOfUsages(ageDao.findAll());
		listObject.setWeightOfUsages(weightDao.findAll());
		return listObject;
	}

	@Override
	public void deleteProduct(Long productId) {
		Production production = productionDao.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("production id [%d] not found", productId)));
		Optionals.ifPresentOrElse(
				cartDetailDao.findByCartDetailIdProduction(productId),
				e -> {
					cartDetailDao.delete(e);
					productionDao.delete(production);
				},
				() ->  {
					throw new IllegalArgumentException(String.format("cart with production id [%d] not found", productId));
				});
	}

	@Override
	public List<Production> getProductByType(String productType) {
		return productionDao.findAllByProductionType(productType);
	}

}
