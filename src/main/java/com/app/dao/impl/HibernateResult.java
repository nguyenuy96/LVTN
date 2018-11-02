package com.app.dao.impl;

import java.sql.Date;
import java.sql.Time;
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

@Repository
public class HibernateResult {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String getMySQLDate() {
		@SuppressWarnings("deprecation")
		Timestamp timestamp = ((Timestamp) getSession().createSQLQuery("select sysdate()").uniqueResult());
		String date = timestamp.toString();
		return date;
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
