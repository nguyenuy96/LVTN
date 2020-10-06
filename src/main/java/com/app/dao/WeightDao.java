package com.app.dao;

import com.app.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightDao extends JpaRepository<Weight, Long> {
    Optional<Weight> findByStartWeightAndEndWeight(double startWeight, double endWeight);
}
