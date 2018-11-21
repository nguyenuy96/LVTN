package com.app.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Cart;
import com.app.service.product.CartService;

@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveCart(@RequestBody Cart cart) {
		cartService.saveOrUpdateCart(cart);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{cartId}",method = RequestMethod.GET)
	public ResponseEntity<Cart> getCart(@PathVariable("cartId") int cartId) {
		Cart cart = cartService.getCart(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
}
