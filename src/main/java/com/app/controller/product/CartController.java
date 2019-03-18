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
import com.app.model.CartDetail;
import com.app.service.product.CartService;

@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveProductIntoCart( @RequestBody CartDetail cartDetail) {
		cartService.saveProductIntoCart(cartDetail);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Cart> saveCart() {
		Cart savedCart = cartService.saveCart();
		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{cartId}",method = RequestMethod.GET)
	public ResponseEntity<List<CartDetail>> listCartProduct(@PathVariable("cartId") int cartId) {
		List<CartDetail> list = cartService.listCartProductByCart(cartId);
		return new ResponseEntity<List<CartDetail>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{productId}/{cartId}",method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteProductCart(@PathVariable(value =  "productId") int productId, @PathVariable(value = "cartId") int cartId) {
		cartService.deleteProductCart(productId, cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
