package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PromotionDao;
import com.app.model.Promotion;
import com.app.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	private PromotionDao promotionDao;

	@Override
	public void saveOrUpdatePromotion(Promotion promotion) {
		promotionDao.save(promotion);
	}

	@Override
	public List<Promotion> listPromotion() {
		return promotionDao.findAll();
	}
}
