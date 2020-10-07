package com.app.dao;

import java.util.List;

import com.app.model.ProductStorageReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStorageDao extends JpaRepository<ProductStorageReception, Long> {
	List<ProductStorageReception> findAllByProduction(Long production);
}
