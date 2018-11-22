package com.app.dao.product;

import java.util.List;

import com.app.model.Cart;
import com.app.model.CartValue;

public interface CartDao {
	
	void saveOrUpdateCart(Cart cart);
	
	void updateCart(Cart cart);

	List<Cart> listCart();

	Cart getCart(int cartId);
	
	void saveProductIntoCart(CartValue cart_Product);
	
	List<CartValue> listCartProduct();
	
	List<CartValue> listProduct(int cartId);
	
	CartValue getCartValue(int cartId, int productId);
}
