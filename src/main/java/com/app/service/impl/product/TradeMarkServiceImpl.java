package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.TradeMarkDao;
import com.app.model.TradeMark;
import com.app.service.product.TradeMarkService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TradeMarkServiceImpl implements TradeMarkService {

	@Autowired
	private TradeMarkDao tradeMarkDao;

	@Transactional
	@Override
	public void saveTradeMark(TradeMark tradeMark) {
		tradeMarkDao.saveOrUpdateLabel(tradeMark);
	}

	@Override
	public List<TradeMark> getTradeMarks() {
		List<TradeMark> listTradeMark = tradeMarkDao.listLabel();
		return listTradeMark;
	}

}
