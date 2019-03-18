package com.app.dao.product;

import java.util.List;

import com.app.model.Cart;
import com.app.model.CartDetail;

public interface CartDao {
	
	Cart saveCart();
	
	void addCartDetail(CartDetail cartDetail);

	List<Cart> listCart();

	Cart getCart(int cartId);
	
	void updateCartDetail(CartDetail cartDetail);
	
	List<CartDetail> listCartDetail();
	
	List<CartDetail> listCartDetailByCartId(int cartId);
	
	CartDetail getCartDetail(int cartId, int productId);
	
	void deleteCartDetail(CartDetail cartDetail);
	
	CartDetail getCartDetailByProductId(int productId);
}
