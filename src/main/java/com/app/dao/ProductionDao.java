package com.app.dao;

import java.util.List;
import java.util.Optional;

import com.app.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionDao extends JpaRepository<Production, Long> {
	
	Optional<Production> findByProductionName(String productName);
	
	List<Production> findAllByProductType(String productType);
}
