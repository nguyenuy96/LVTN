package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.model.Cart;
import com.app.model.CartDetail;
import com.app.service.CartService;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/product-cart")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveProductIntoCart( @RequestBody CartDetail cartDetail) {
		cartService.addProductionIntoCart(cartDetail);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cart saveCart() {
		return cartService.saveCart();
	}
	
	@GetMapping(path = "/{cartId}")
	@ResponseStatus(HttpStatus.OK)
	public List<CartDetail> listCartProduct(@PathVariable("cartId") Long cartId) {
		return cartService.listCartDetailByCartId(cartId);
	}
	
	@DeleteMapping(path = "/{productId}/{cartId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProductCart(@PathVariable(value =  "productId") Long productId,
														@PathVariable(value = "cartId") Long cartId) {
		cartService.deleteCartDetail(productId, cartId);
	}
	
}
