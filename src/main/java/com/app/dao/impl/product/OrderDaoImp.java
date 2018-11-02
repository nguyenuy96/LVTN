package com.app.dao.impl.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.product.OrderDao;
import com.app.model.Order;
@Repository
public class OrderDaoImp implements OrderDao{

	@Override
	public void saveOrUpdateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> listOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
