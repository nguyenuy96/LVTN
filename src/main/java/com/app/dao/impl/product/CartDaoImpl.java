package com.app.dao.impl.product;

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
		hibernate.getSession().saveOrUpdate(cart);
	}

	@Override
	public List<Cart> listCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getOrder(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

}
