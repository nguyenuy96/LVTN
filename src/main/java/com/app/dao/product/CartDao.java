package com.app.dao.product;

import java.util.List;

import com.app.model.Cart;

public interface CartDao {
	
	void saveOrUpdateCart(Cart cart);

	List<Cart> listCard();

	Cart getOrder(int cartId);
}
