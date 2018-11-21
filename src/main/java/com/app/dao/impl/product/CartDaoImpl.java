package com.app.dao.impl.product;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.CartDao;
import com.app.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateCart(Cart cart) {
		Timestamp lastUpdateDate = hibernate.getSQLDate();
		cart.setLastUpdateDate(lastUpdateDate);
		hibernate.getSession().saveOrUpdate(cart);
	}

	@Override
	public List<Cart> listCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCart(int cartId) {
		Cart cart = hibernate.getSession().byId(Cart.class).load(cartId);
		return cart;
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
