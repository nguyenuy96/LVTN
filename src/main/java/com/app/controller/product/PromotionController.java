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

import com.app.exception.ExceptionHandle;
import com.app.model.Promotion;
import com.app.service.product.PromotionService;

@CrossOrigin
@RestController
@RequestMapping(path = "/promotion")
public class PromotionController {
	@Autowired
	private PromotionService promotionService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> savePromotion(@RequestBody Promotion promotion) throws ExceptionHandle{
		promotionService.saveOrUpdatePromotion(promotion);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Promotion>> listPromotion(@RequestBody Promotion promotion) {
		List<Promotion> list = promotionService.listPromotion();
		return new ResponseEntity<List<Promotion>>(list, HttpStatus.OK);
	}
}
