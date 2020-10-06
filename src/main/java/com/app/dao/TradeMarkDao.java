package com.app.dao;

import java.util.Optional;

import com.app.model.TradeMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeMarkDao extends JpaRepository<TradeMark, Long> {
	Optional<TradeMark> findByTradeMark(String tradeMark);
}
