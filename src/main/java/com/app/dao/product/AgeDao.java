package com.app.dao.product;

import java.util.List;

import com.app.model.Age;

public interface AgeDao {

	void saveOrUpdateAge(Age age);

	List<Age> listAge();
	
	Age getAge(int ageId);
}
