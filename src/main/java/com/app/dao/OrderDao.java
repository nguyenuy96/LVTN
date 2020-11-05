package com.app.dao;

import java.util.List;

import com.app.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
	List<Order> findAllByOrderState(String orderState);
	List<Order> findAllByContactAndOrderState(Long contactId, String orderState);
	List<Order> findAllByContact(Long contactId);
}
