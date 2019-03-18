package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CartDao;
import com.app.dao.product.ProductDao;
import com.app.model.Cart;
import com.app.model.CartDetail;
import com.app.service.product.CartService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired ProductDao productDao;

	@Transactional
	@Override
	public Cart saveCart() {
		Cart savedCart = cartDao.saveCart();
		return savedCart;
	}

	@Override
	public Cart getCart(int cartId) {
		Cart cart = cartDao.getCart(cartId);
		return cart;
	}

	@Transactional
	@Override
	public void saveProductIntoCart(CartDetail cartDetail) {
		CartDetail updatedCartDetail = cartDao.getCartDetail(cartDetail.getCart().getCartId(), cartDetail.getProduct().getProductId());
		if(updatedCartDetail != null) {
			int amount = cartDetail.getAmount();
			updatedCartDetail.setAmount(amount);
			cartDao.updateCartDetail(updatedCartDetail);
		}else {
			cartDao.addCartDetail(cartDetail);
		}
		
	}

	@Override
	public List<CartDetail> listCartProduct() {
		List<CartDetail> list = cartDao.listCartDetailByCartId(1);
		return list;
	}

	@Override
	public List<CartDetail> listCartProductByCart(int cartId) {
		List<CartDetail> list = cartDao.listCartDetailByCartId(cartId);
		return list;
	}

	@Transactional
	@Override
	public void deleteProductCart(int productId, int cartId) {
		CartDetail deletedCartDetail = cartDao.getCartDetail(cartId, productId);
		cartDao.deleteCartDetail(deletedCartDetail);
	}

}
