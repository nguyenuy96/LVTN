package com.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Cart;
import com.app.model.CartDetail;
import com.app.service.product.CartService;

@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping
	public ResponseEntity<HttpStatus> saveProductIntoCart( @RequestBody CartDetail cartDetail) {
		cartService.addProductionIntoCart(cartDetail);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Cart> saveCart() {
		Cart savedCart = cartService.saveCart();
		return new ResponseEntity<>(savedCart, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{cartId}")
	public ResponseEntity<List<CartDetail>> listCartProduct(@PathVariable("cartId") Long cartId) {
		List<CartDetail> list = cartService.listCartDetailByCartId(cartId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{productId}/{cartId}")
	public ResponseEntity<HttpStatus> deleteProductCart(@PathVariable(value =  "productId") Long productId,
														@PathVariable(value = "cartId") Long cartId) {
		cartService.deleteCartDetail(productId, cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
