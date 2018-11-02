package com.app.dao.product;

import java.util.List;

import com.app.model.Order;

public interface OrderDao {
	
	void saveOrUpdateOrder(Order order);

	List<Order> listOrder();

	Order getOrder(int orderId);
}
