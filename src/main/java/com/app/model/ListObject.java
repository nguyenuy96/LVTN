package com.app.model;

import java.util.List;

public class ListObject {

	private List<TradeMark> tradeMarks;
	private List<ProductType> productTypes;
	private List<Warehouse> warehouses;
	private List<Promotion> promotions;
	private List<Age> ages;
	private List<Weight> weights;

	public List<TradeMark> getTradeMarks() {
		return tradeMarks;
	}

	public void setTradeMarks(List<TradeMark> tradeMarks) {
		this.tradeMarks = tradeMarks;
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public List<Age> getAges() {
		return ages;
	}

	public void setAges(List<Age> ages) {
		this.ages = ages;
	}

	public List<Weight> getWeights() {
		return weights;
	}

	public void setWeights(List<Weight> weights) {
		this.weights = weights;
	}

}
