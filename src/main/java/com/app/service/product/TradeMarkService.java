package com.app.service.product;

import java.util.List;

import com.app.model.TradeMark;

public interface TradeMarkService {
	void saveTradeMark(TradeMark tradeMark);

	List<TradeMark> getTradeMarks();
	
	TradeMark getTradeMark(int tradeMarkId);
	
	TradeMark getTradeMarkByName(String tradeMark);
}
