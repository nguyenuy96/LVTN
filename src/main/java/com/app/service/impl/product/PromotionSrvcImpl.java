package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.PromotionDao;
import com.app.exception.ExceptionHandle;
import com.app.model.Promotion;
import com.app.service.product.PromotionService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PromotionSrvcImpl implements PromotionService{

	@Autowired
	private PromotionDao promotionDao;
	
	@Transactional
	@Override
	public void saveOrUpdatePromotion(Promotion promotion) throws ExceptionHandle{
		promotionDao.saveOrUpdatePromotion(promotion);
	}

	@Override
	public List<Promotion> listPromotion() {
		List<Promotion> list = promotionDao.listPromotion();
		return list;
	}

	@Override
	public Promotion getPromotion(int promotionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
