package com.app.dao.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.PromotionDao;
import com.app.model.Promotion;

@Repository
public class PromotionDaoImpl implements PromotionDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdatePromotion(Promotion promotion) {
		hibernate.getSession().saveOrUpdate(promotion);
	}

	@Override
	public List<Promotion> listPromotion() {
		List<Promotion> listPromotion = hibernate.getResultList(Promotion.class);
		return listPromotion;
	}

	@Override
	public Promotion getPromotion(int promotionId) {
		Promotion promotion = hibernate.getById(Promotion.class, promotionId);
		return promotion;
	}

}
