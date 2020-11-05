package com.app.dao;

import com.app.model.AgeOfUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeDao extends JpaRepository<AgeOfUsage, Long> {

}
