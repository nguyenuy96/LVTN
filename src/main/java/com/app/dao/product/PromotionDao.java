package com.app.dao.product;

import java.util.List;

import com.app.model.Promotion;

public interface PromotionDao {
	
	void saveOrUpdatePromotion(Promotion promotion);

	List<Promotion> listPromotion();

	Promotion getPromotion(int promotionId);
}
