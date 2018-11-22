package com.app.dao.impl.product;

import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.CartDao;
import com.app.model.Cart;
import com.app.model.CartProductId;
import com.app.model.CartValue;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveOrUpdateCart(Cart cart) {
		Date lastUpdateDate = (Date) hibernate.getSQLDate();
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
	
	@Override
	public void saveProductIntoCart(CartValue cart_Product) {
		hibernate.getSession().saveOrUpdate(cart_Product);
	}

	@Override
	public List<CartValue> listCartProduct() {
		List<CartValue> list = hibernate.getResultList(CartValue.class);
		return list;
	}

	@Override
	public List<CartValue> listProduct(int cartId) {
//		CriteriaBuilder criteriaBuilder = hibernate.getSession().getCriteriaBuilder();
//		CriteriaQuery<Cart_Product> criteriaQuery = criteriaBuilder.createQuery(Cart_Product.class);
//		Root<Cart_Product> root = criteriaQuery.from(Cart_Product.class);
		return null;
	}

	@Override
	public CartValue getCartValue(int cartId, int productId) {
		CriteriaBuilder criteriaBuilder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<CartValue> criteriaQuery = criteriaBuilder.createQuery(CartValue.class);
		Root<CartValue> root = criteriaQuery.from(CartValue.class);
		criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("cart"), cartId), criteriaBuilder.equal(root.get("product"), productId)));
		Query<CartValue> query = hibernate.getSession().createQuery(criteriaQuery);
		List<CartValue> list = query.getResultList();
		CartValue cartValue = list.size() != 0 ? list.get(0) : null;
		return cartValue;
	}

}
