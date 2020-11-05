package com.app.service;

import java.util.List;

import com.app.model.WeightOfUsage;

public interface WeightService {
	void saveWeight(WeightOfUsage weightOfUsage);

	List<WeightOfUsage> listWeight();

	WeightOfUsage getWeight(Long weightId);
}
