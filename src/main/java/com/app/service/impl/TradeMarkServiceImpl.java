package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TradeMarkDao;
import com.app.model.TradeMark;
import com.app.service.TradeMarkService;

@Service
public class TradeMarkServiceImpl implements TradeMarkService {

	@Autowired
	private TradeMarkDao tradeMarkDao;

	@Transactional
	@Override
	public void saveTradeMark(TradeMark tradeMark) {
		tradeMarkDao.save(tradeMark);
	}

	@Override
	public List<TradeMark> getTradeMarks() {
		return tradeMarkDao.findAll();
	}

	@Override
	public TradeMark getTradeMark(Long tradeMarkId) {
		return tradeMarkDao.findById(tradeMarkId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Trade mark [%d] not found", tradeMarkId)));
	}

	@Override
	public TradeMark getTradeMarkByName(String tradeMark) {
		return tradeMarkDao.findByTradeMark(tradeMark)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Trade mark [%s] not found", tradeMark)));
	}
}
