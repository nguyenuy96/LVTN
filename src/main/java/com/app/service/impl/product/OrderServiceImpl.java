package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.OrderDao;
import com.app.model.Order;
import com.app.service.product.OrderService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Transactional
	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrUpdateOrder(order);
	}

	@Override
	public List<Order> listOrderByState(String orderState) {
		List<Order> list = orderDao.listOrderByOrderState(orderState);
		return list;
	}

	@Override
	public List<Order> listOrderByCustomer(int customerId, String orderState) {
		List<Order> list = orderDao.listOrderByCustomer(customerId, orderState);
		return list;
	}

	@Override
	public List<Order> listOrderByCus(int customerId) {
		List<Order> list = orderDao.getOrderByCustomer(customerId);
		return list;
	}

}
