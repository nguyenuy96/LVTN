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

import com.app.model.Cart;
import com.app.model.CartValue;
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
	
	@RequestMapping(path = "/insert",method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProductIntoCart(@RequestBody CartValue cart_Product) {
		cartService.saveProductIntoCart(cart_Product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{cartId}",method = RequestMethod.GET)
	public ResponseEntity<List<CartValue>> getCart(@PathVariable("cartId") int cartId) {
		List<CartValue> list = cartService.listCartProductByCart(cartId);
		return new ResponseEntity<List<CartValue>>(list, HttpStatus.OK);
	}
	
//	@RequestMapping(path = "/list",method = RequestMethod.GET)
//	public ResponseEntity<List<Cart_Product>> listCartProduct() {
//		List<Cart_Product> list = cartService.listCartProduct();
//		return new ResponseEntity<List<Cart_Product>>(list, HttpStatus.OK);
//	}
	
}
