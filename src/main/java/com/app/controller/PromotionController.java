package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Promotion;
import com.app.service.PromotionService;

@CrossOrigin
@RestController
@RequestMapping(path = "/promotion")
public class PromotionController {
	@Autowired
	private PromotionService promotionService;

	@PostMapping
	public ResponseEntity<HttpStatus> savePromotion(@RequestBody Promotion promotion) {
		promotionService.saveOrUpdatePromotion(promotion);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Promotion>> listPromotion() {
		List<Promotion> list = promotionService.listPromotion();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
