package com.app.dao;

import com.app.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseDao extends JpaRepository<Warehouse, Long> {

}
