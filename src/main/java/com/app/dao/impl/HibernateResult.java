package com.app.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.CartDetail;
import com.app.model.Production;

@Repository
public class HibernateResult {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("deprecation")
	public String getMySQLDate() {
		Timestamp timestamp = ((Timestamp) getSession().createSQLQuery("select sysdate()").uniqueResult());
		String date = timestamp.toString();
		return date;
	}

	@SuppressWarnings("deprecation")
	public Date getSQLDate() {
		Date lastUpdateDate = (Date) getSession().createSQLQuery("select curdate()").uniqueResult();
//		String date = timestamp.toString();
		return lastUpdateDate;
	}

	public <T> Query<T> inputStringQuery(Class<T> resultClass, String condition, String value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	};

	public <T> Query<T> inputIntQuery(Class<T> resultClass, String condition, int value) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(condition), value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		return query;
	};

	public List<Production> listProductByCart(int cartId) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Production> criteriaQuery = criteriaBuilder.createQuery(Production.class);
		Root<CartDetail> root = criteriaQuery.from(CartDetail.class);
		criteriaQuery.select(root.<Production>get("cartDetailId").get("product"))
				.where(criteriaBuilder.equal(root.get("cartDetailId").get("cart"), cartId));
		List<Production> list = getSession().createQuery(criteriaQuery).getResultList();
		return list;
	};

	public <T> List<T> getResultList(Class<T> resultClass) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(resultClass);
		Root<T> root = criteriaQuery.from(resultClass);
		criteriaQuery.select(root);
		Query<T> query = getSession().createQuery(criteriaQuery);
		List<T> list = query.getResultList();
		return list;
	}

	public <T> T getById(Class<T> clazz, int id) {
		return getSession().byId(clazz).load(id);
	}
}
