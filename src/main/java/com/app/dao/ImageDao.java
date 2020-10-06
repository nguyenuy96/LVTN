package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ProductionImage;

import java.util.Optional;

@Repository
public interface ImageDao extends JpaRepository<ProductionImage, Long> {
	Optional<ProductionImage> findByImageName(String imageName);
}
