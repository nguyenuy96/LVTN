package com.app.service;

import java.util.List;

import com.app.model.Promotion;

public interface PromotionService {
	
	void saveOrUpdatePromotion(Promotion promotion);

	List<Promotion> listPromotion();
}
