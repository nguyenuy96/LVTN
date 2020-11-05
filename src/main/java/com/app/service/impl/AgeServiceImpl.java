package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AgeDao;
import com.app.model.AgeOfUsage;
import com.app.service.AgeService;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AgeServiceImpl implements AgeService{

	@Autowired
	private AgeDao ageDao;
	
	@Transactional
	@Override
	public void saveAge(AgeOfUsage ageOfUsage) {
		ageDao.save(ageOfUsage);
	}

	@Override
	public List<AgeOfUsage> listAge() {
		return ageDao.findAll();
	}

	@Override
	public AgeOfUsage getAge(Long ageId) {
		return ageDao.findById(ageId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("age with id [%d] not found", ageId)));
	}
	

}
