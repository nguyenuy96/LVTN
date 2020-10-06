package com.app.dao;

import java.util.List;
import java.util.Optional;

import com.app.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionDao extends JpaRepository<Production, Long> {
	
	void saveProduct(Production production);

	List<Production> listProduct();

	Production getProduct(int productId);

	void deleteProduct(Production production);
	
	Optional<Production> findByProductionName(String productName);
	
	List<Production> findByProductType(String productType);
}
