package com.app.service.product;

import java.util.List;

import com.app.model.Age;

public interface AgeService {

	void saveAge(Age age);

	List<Age> listAge();

	Age getAge(int ageId);
}
