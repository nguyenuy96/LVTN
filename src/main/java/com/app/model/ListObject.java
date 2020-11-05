package com.app.model;

import lombok.Data;

import java.util.List;

@Data
public class ListObject {

	private List<TradeMark> tradeMarks;
	private List<ProductionType> productionTypes;
	private List<Warehouse> warehouses;
	private List<Promotion> promotions;
	private List<AgeOfUsage> ageOfUsages;
	private List<WeightOfUsage> weightOfUsages;
}
