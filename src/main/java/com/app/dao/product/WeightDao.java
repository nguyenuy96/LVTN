package com.app.dao.product;

import java.util.List;

import com.app.model.Weight;

public interface WeightDao {

	void saveOrUpdateWeight(Weight weight);

	List<Weight> listWeight();

	Weight getWeight(int weightId);

}
