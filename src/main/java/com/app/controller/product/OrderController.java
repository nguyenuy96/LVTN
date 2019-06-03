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

import com.app.model.Order;
import com.app.service.product.OrderService;

@CrossOrigin
@RestController
@RequestMapping(path = "/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{orderState}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> listOrdetByState(@PathVariable(value = "orderState") String orderState) {
		List<Order> list = orderService.listOrderByState(orderState);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

	@RequestMapping(path = "/owner/{customerId}/{orderState}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> listWaitingOrderBuCusId(@PathVariable(value = "customerId") int customerId,
			@PathVariable(value = "orderState") String orderState) {
		List<Order> list = orderService.listOrderByCustomer(customerId, orderState);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/owner/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> listOrderByCus(@PathVariable(value = "customerId") int customerId) {
		List<Order> list = orderService.listOrderByCus(customerId);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

}
