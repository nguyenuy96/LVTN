package com.app.service.product;

import java.util.List;

import com.app.model.Weight;

public interface WeightService {
	void saveWeight(Weight weight);

	List<Weight> listWeight();

	Weight getWeight(int weightId);
}
