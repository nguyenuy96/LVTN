package com.app.dao;

import com.app.model.CartDetail;
import com.app.model.CartDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDetailDao extends JpaRepository<CartDetail, CartDetailId> {
    Optional<CartDetail> findByIdProductionId(Long productionId);
    List<CartDetail> findAllByIdCartId(Long cartId);
}
