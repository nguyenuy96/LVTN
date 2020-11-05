package com.app.service;

import java.util.List;

import com.app.model.Order;

public interface OrderService {
	void saveOrder(Order order);
	
	List<Order> listOrderByState(String orderState);
	
	List<Order> listOrderByCustomer(Long customerId, String orderState);
	
	List<Order> listOrderByCus(Long customerId);
}
