package com.app.dao.product;

import java.util.List;

import com.app.model.Cart;

public interface CartDao {
	
	void saveOrUpdateCart(Cart cart);
	
	void updateCart(Cart cart);

	List<Cart> listCart();

	Cart getCart(int cartId);
}
