package com.app.service.product;

import java.util.List;

import com.app.model.Cart;
import com.app.model.CartValue;

public interface CartService {

	void saveOrUpdateCart(Cart cart);

	Cart getCart(int cartId);

	void saveProductIntoCart(CartValue cart_Product);

	List<CartValue> listCartProduct();

	List<CartValue> listCartProductByCart(int cartId);
}
