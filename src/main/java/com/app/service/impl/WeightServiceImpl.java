package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import com.app.dao.WeightDao;
import com.app.model.WeightOfUsage;
import com.app.service.WeightService;
@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	private WeightDao weightDao;

	@Override
	public void saveWeight(WeightOfUsage weightOfUsage) {
		Optionals.ifPresentOrElse(
				weightDao.findByStartWeightAndEndWeight(weightOfUsage.getStartWeight(), weightOfUsage.getEndWeight()),
				e -> {
					e.setStartWeight(weightOfUsage.getStartWeight());
					e.setEndWeight(weightOfUsage.getEndWeight());
					e.setSize(weightOfUsage.getSize());
					weightDao.save(e);
					},
				() -> weightDao.save(weightOfUsage));
	}

	@Override
	public List<WeightOfUsage> listWeight() {
		return weightDao.findAll();
	}

	@Override
	public WeightOfUsage getWeight(Long weightId) {
		return weightDao.findById(weightId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Weight with id [%d] not found", weightId)));
	}

}
