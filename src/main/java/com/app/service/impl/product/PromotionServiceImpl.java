package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PromotionDao;
import com.app.exception.ExceptionHandle;
import com.app.model.Promotion;
import com.app.service.product.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	private PromotionDao promotionDao;
	
	@Transactional
	@Override
	public void saveOrUpdatePromotion(Promotion promotion) throws ExceptionHandle{
		promotionDao.save(promotion);
	}

	@Override
	public List<Promotion> listPromotion() {
		return promotionDao.findAll();
	}
}
