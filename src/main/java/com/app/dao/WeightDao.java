package com.app.dao;

import com.app.model.WeightOfUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightDao extends JpaRepository<WeightOfUsage, Long> {
    Optional<WeightOfUsage> findByStartWeightAndEndWeight(double startWeight, double endWeight);
}
