package com.app.dao;

import java.util.List;

import com.app.model.Order;

public interface OrderDao {

	void saveOrUpdateOrder(Order order);

	List<Order> listOrder();

	Order getOrder(int orderId);

	Order getOrderByCart(int cartId);

	List<Order> listOrderByOrderState(String orderState);

	List<Order> listOrderByCustomer(int customerId, String orderState);

	void approveOrder(Order order);
	
	List<Order> getOrderByCustomer(int customerId);
}
