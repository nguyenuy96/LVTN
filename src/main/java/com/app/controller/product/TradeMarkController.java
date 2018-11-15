package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(path = "/get/{tradeMarkId}", method = RequestMethod.GET)
	public ResponseEntity<TradeMark> getTradeMark(@PathVariable("tradeMarkId") int tradeMarkId) {
		TradeMark tradeMark = tradeMarkService.getTradeMark(tradeMarkId);
		return new ResponseEntity<TradeMark>(tradeMark, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/getByName/{tradeMark}", method = RequestMethod.GET)
	public ResponseEntity<TradeMark> getTradeMarkByName(@PathVariable("tradeMark") String tradeMark) {
		TradeMark retLabel = tradeMarkService.getTradeMarkByName(tradeMark);
		return new ResponseEntity<TradeMark>(retLabel, HttpStatus.OK);
	}
}
