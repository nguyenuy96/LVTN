package com.app.service.product;

import java.util.List;

import com.app.model.Cart;
import com.app.model.CartDetail;

public interface CartService {

	Cart saveCart();

	Cart getCart(int cartId);

	void saveProductIntoCart(CartDetail cart_Product);

	List<CartDetail> listCartProduct();

	List<CartDetail> listCartProductByCart(int cartId);
	void deleteProductCart(int productId, int cartId);
}
