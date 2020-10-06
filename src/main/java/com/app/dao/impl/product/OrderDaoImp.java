package com.app.dao.impl.product;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.OrderDao;
import com.app.model.Order;

@Repository
public class OrderDaoImp implements OrderDao {
	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateOrder(Order order) {
		hibernate.getSession().saveOrUpdate(order);
	}

	@Override
	public List<Order> listOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int orderId) {
		Order order = hibernate.getById(Order.class, orderId);
		return order;
	}

	@Override
	public Order getOrderByCart(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listOrderByOrderState(String orderState) {
		Query<Order> query = hibernate.inputStringQuery(Order.class, "orderState", orderState);
		List<Order> list = query.getResultList();
		return list;
	}

	@Override
	public List<Order> listOrderByCustomer(int customerId, String orderState) {
		CriteriaBuilder criteriaBuilder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
		Root<Order> root = criteriaQuery.from(Order.class);
		criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("customer"), customerId),
				criteriaBuilder.equal(root.get("orderState"), orderState)));
		Query<Order> query = hibernate.getSession().createQuery(criteriaQuery);
		List<Order> list = query.getResultList();
		return list;
	}

	@Override
	public void approveOrder(Order order) {
		hibernate.getSession().update(order);
	}

	@Override
	public List<Order> getOrderByCustomer(int customerId) {
		CriteriaBuilder criteriaBuilder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
		Root<Order> root = criteriaQuery.from(Order.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("customer"), customerId));
		Query<Order> query = hibernate.getSession().createQuery(criteriaQuery);
		List<Order> list = query.getResultList();
		return list;
	}

}
