package com.app.service;

import java.util.List;

import com.app.model.AgeOfUsage;

public interface AgeService {

	void saveAge(AgeOfUsage ageOfUsage);

	List<AgeOfUsage> listAge();

	AgeOfUsage getAge(Long ageId);
}
