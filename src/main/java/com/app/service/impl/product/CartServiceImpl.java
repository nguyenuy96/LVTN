package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CartDao;
import com.app.dao.product.ProductDao;
import com.app.model.Cart;
import com.app.model.CartValue;
import com.app.model.Product;
import com.app.service.product.CartService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;
	
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

	@Transactional
	@Override
	public void saveProductIntoCart(CartValue cart_Product) {
//		Product product = productDao.getProduct(cart_Product.getProduct().getProductId());
//		Cart cart = cartDao.getCart(cart_Product.getCart().getCartId());
//		cart_Product.setCart(cart);
//		cart_Product.setProduct(product);
		CartValue cartValue = cartDao.getCartValue(cart_Product.getCart().getCartId(), cart_Product.getProduct().getProductId());
		if(cartValue != null) {
			int amount = cart_Product.getAmount();
			cartValue.setAmount(cartValue.getAmount() + amount);
			cartDao.saveProductIntoCart(cartValue);
		}else {
			cartDao.saveProductIntoCart(cart_Product);
		}
		
	}

	@Override
	public List<CartValue> listCartProduct() {
		List<CartValue> list = cartDao.listCartProduct();
		return list;
	}

	@Override
	public List<CartValue> listCartProductByCart(int cartId) {
		List<CartValue> list = cartDao.listProduct(cartId);
		return list;
	}

}
