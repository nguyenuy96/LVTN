package com.app.dao.product;

import java.util.List;

import com.app.model.TradeMark;

public interface TradeMarkDao {
	void saveOrUpdateLabel(TradeMark label);

	List<TradeMark> listLabel();

	TradeMark getLabel(int tradeMarkId);
	
	boolean isValidTradeMark(String tradeMark);
	
	TradeMark getLabelByName(String tradeMark);
}
