package com.app.dao;

import com.app.model.ExportReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExportDao extends JpaRepository<ExportReceipt, Long> {

}