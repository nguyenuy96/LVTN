package com.app.dao.impl.product;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.TradeMarkDao;
import com.app.model.TradeMark;

@Repository
public class TradeMarkDaoImpl implements TradeMarkDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateLabel(TradeMark label) {
		hibernate.getSession().saveOrUpdate(label);
	}

	@Override
	public List<TradeMark> listLabel() {
		List<TradeMark> listLabel = hibernate.getResultList(TradeMark.class);
		return listLabel;
	}

	@Override
	public TradeMark getLabel(int tradeMarkId) {
		TradeMark label = hibernate.getById(TradeMark.class, tradeMarkId);
		return label;
	}

	@Override
	public boolean isValidTradeMark(String tradeMark) {
		Query<TradeMark> query = hibernate.inputStringQuery(TradeMark.class, "tradeMark", tradeMark);
		boolean isValid = (query.list().size() == 1) ? true : false;
		return isValid;
	}

	@Override
	public TradeMark getLabelByName(String tradeMark) {
		Query<TradeMark> query = hibernate.inputStringQuery(TradeMark.class, "tradeMark", tradeMark);
		TradeMark retLabel = query.getSingleResult();
		return retLabel;
	}

}
