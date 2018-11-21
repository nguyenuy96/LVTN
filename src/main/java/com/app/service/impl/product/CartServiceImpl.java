package com.app.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CartDao;
import com.app.model.Cart;
import com.app.service.product.CartService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Transactional
	@Override
	public void saveOrUpdateCart(Cart cart) {
		cartDao.saveOrUpdateCart(cart);
	}

	@Override
	public Cart getCart(int cartId) {
		Cart cart = cartDao.getCart(cartId);
		return cart;
	}

}
