package com.app.dao.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.WeightDao;
import com.app.model.Weight;
@Repository
public class WeightDaoImpl implements WeightDao{

	@Autowired
	private HibernateResult hibernate;
	
	@Override
	public void saveOrUpdateWeight(Weight weight) {
		hibernate.getSession().saveOrUpdate(weight);
	}

	@Override
	public List<Weight> listWeight() {
		List<Weight> listWeight = hibernate.getResultList(Weight.class);
		return listWeight;
	}

	@Override
	public Weight getWeight(int weightId) {
		Weight weight = hibernate.getById(Weight.class, weightId);
		return weight;
	}

}
