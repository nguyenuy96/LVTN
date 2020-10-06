package com.app.dao;

import com.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Modified on 2020/10/01
 * Entry for Customer
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

}
