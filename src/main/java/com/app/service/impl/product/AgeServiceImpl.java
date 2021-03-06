package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.AgeDao;
import com.app.model.Age;
import com.app.service.product.AgeService;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AgeServiceImpl implements AgeService{

	@Autowired
	private AgeDao ageDao;
	
	@Transactional
	@Override
	public void saveAge(Age age) {
		ageDao.saveOrUpdateAge(age);
	}

	@Override
	public List<Age> listAge() {
		List<Age> listAge = ageDao.listAge();
		return listAge;
	}

	@Override
	public Age getAge(int ageId) {
		Age age = ageDao.getAge(ageId);
		return age;
	}
	

}
