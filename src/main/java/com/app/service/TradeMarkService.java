package com.app.service;

import java.util.List;

import com.app.model.TradeMark;

public interface TradeMarkService {
	void saveTradeMark(TradeMark tradeMark);

	List<TradeMark> getTradeMarks();
	
	TradeMark getTradeMark(Long tradeMarkId);
	
	TradeMark getTradeMarkByName(String tradeMark);
}
