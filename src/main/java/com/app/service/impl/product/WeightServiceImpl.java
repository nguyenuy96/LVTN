package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.WeightDao;
import com.app.model.Weight;
import com.app.service.product.WeightService;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WeightServiceImpl implements WeightService{

	@Autowired
	private WeightDao weightDao;
	
	@Transactional
	@Override
	public void saveWeight(Weight weight) {
		weightDao.saveOrUpdateWeight(weight);
	}

	@Override
	public List<Weight> listWeight() {
		List<Weight> listWeight = weightDao.listWeight();
		return listWeight;
	}

	@Override
	public Weight getWeight(int weightId) {
		Weight weight = weightDao.getWeight(weightId);
		return weight;
	}

}
