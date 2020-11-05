package com.app.service;

import java.util.List;

import com.app.model.Cart;
import com.app.model.CartDetail;

public interface CartService {

	Cart saveCart();

	void addProductionIntoCart(CartDetail cartDetail);

	List<CartDetail> listCartDetailByCartId(Long cartId);
	void deleteCartDetail(Long productId, Long cartId);
}
