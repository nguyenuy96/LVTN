package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Order;
import com.app.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping(path = "/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<HttpStatus> saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "/{orderState}")
	public ResponseEntity<List<Order>> listOrderByState(@PathVariable(value = "orderState") String orderState) {
		List<Order> list = orderService.listOrderByState(orderState);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}