package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.TradeMark;
import com.app.service.product.TradeMarkService;

@CrossOrigin
@RestController
@RequestMapping(path = "/trademark")
public class TradeMarkController {
	@Autowired
	private TradeMarkService tradeMarkService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addTradeMark(@RequestBody TradeMark tradeMark) {
		tradeMarkService.saveTradeMark(tradeMark);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<TradeMark>> listTradeMark() {
		List<TradeMark> listTradeMark = tradeMarkService.getTradeMarks();
		return new ResponseEntity<List<TradeMark>>(listTradeMark, HttpStatus.OK);
	}
}
