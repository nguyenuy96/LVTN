package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import com.app.dao.WeightDao;
import com.app.model.Weight;
import com.app.service.product.WeightService;
@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	private WeightDao weightDao;

	@Override
	public void saveWeight(Weight weight) {
		Optionals.ifPresentOrElse(
				weightDao.findByStartWeightAndEndWeight(weight.getStartWeight(), weight.getEndWeight()),
				e -> {
					e.setStartWeight(weight.getStartWeight());
					e.setEndWeight(weight.getEndWeight());
					e.setSize(weight.getSize());
					weightDao.save(e);
					},
				() -> weightDao.save(weight));
	}

	@Override
	public List<Weight> listWeight() {
		return weightDao.findAll();
	}

	@Override
	public Weight getWeight(Long weightId) {
		return weightDao.findById(weightId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Weight with id [%d] not found", weightId)));
	}

}
