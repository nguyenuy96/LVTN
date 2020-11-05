package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.TradeMark;
import com.app.service.TradeMarkService;

@CrossOrigin
@RestController
@RequestMapping(path = "/trademark")
public class TradeMarkController {
	@Autowired
	private TradeMarkService tradeMarkService;

	@PostMapping
	public ResponseEntity<HttpStatus> addNewTradeMark(@RequestBody TradeMark tradeMark) {
		tradeMarkService.saveTradeMark(tradeMark);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TradeMark>> getAllTradeMark() {
		return new ResponseEntity<>(tradeMarkService.getTradeMarks(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{tradeMarkId}")
	public ResponseEntity<TradeMark> getTradeMark(@PathVariable("tradeMarkId") Long tradeMarkId) {
		return new ResponseEntity<>(tradeMarkService.getTradeMark(tradeMarkId), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{tradeMark}")
	public ResponseEntity<TradeMark> getTradeMarkByName(@PathVariable("tradeMark") String tradeMark) {
		return new ResponseEntity<>(tradeMarkService.getTradeMarkByName(tradeMark), HttpStatus.OK);
	}
}
