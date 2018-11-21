package com.app.service.product;

import com.app.model.Cart;

public interface CartService {
	
	void saveOrUpdateCart(Cart cart);
	
	Cart getCart(int cartId);
}
