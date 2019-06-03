package com.app.service.product;

import java.util.List;

import com.app.exception.ExceptionHandle;
import com.app.model.Promotion;

public interface PromotionService {
	
	void saveOrUpdatePromotion(Promotion promotion) throws ExceptionHandle;

	List<Promotion> listPromotion();

	Promotion getPromotion(int promotionId);
}
