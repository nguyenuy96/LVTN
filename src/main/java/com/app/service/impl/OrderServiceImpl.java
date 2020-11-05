package com.app.service.impl;

import com.app.dao.OrderDao;
import com.app.model.Order;
import com.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> listOrderByState(String orderState) {
        return orderDao.findAllByOrderState(orderState);
    }

    @Override
    public List<Order> listOrderByCustomer(Long customerId, String orderState) {
        return orderDao.findAllByContactAndOrderState(customerId, orderState);
    }

    @Override
    public List<Order> listOrderByCus(Long customerId) {
        return orderDao.findAllByContact(customerId);
    }
}
