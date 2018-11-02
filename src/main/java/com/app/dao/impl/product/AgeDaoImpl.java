package com.app.dao.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.AgeDao;
import com.app.model.Age;

@Repository
public class AgeDaoImpl implements AgeDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateAge(Age age) {
		hibernate.getSession().saveOrUpdate(age);
	}

	@Override
	public List<Age> listAge() {
		List<Age> listAges = hibernate.getResultList(Age.class);
		return listAges;
	}

	@Override
	public Age getAge(int ageId) {
		Age age = hibernate.getById(Age.class, ageId);
		return age;
	}

}
