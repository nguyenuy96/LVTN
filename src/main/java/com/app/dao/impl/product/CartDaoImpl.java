package com.app.dao.impl.product;

import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.CartDao;
import com.app.model.Cart;
import com.app.model.CartDetail;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public Cart saveCart() {
		Cart cart = new Cart();
		Date lastUpdateDate = hibernate.getSQLDate();
		cart.setLastUpdateDate(lastUpdateDate);
		hibernate.getSession().save(cart);
		return cart;
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
	public void addCartDetail(CartDetail cartDetail) {
		hibernate.getSession().save(cartDetail);
	}

	@Override
	public void updateCartDetail(CartDetail cartDetail) {
		Cart cart = cartDetail.getCart();
		Date lastUpdateDate = hibernate.getSQLDate();
		cart.setLastUpdateDate(lastUpdateDate);
		cartDetail.setCart(cart);
		hibernate.getSession().merge(cartDetail);
		hibernate.getSession().update(cartDetail);
		hibernate.getSession().merge(cart);
		hibernate.getSession().update(cart);
	}

	@Override
	public List<CartDetail> listCartDetail() {
		List<CartDetail> list = hibernate.getResultList(CartDetail.class);
		return list;
	}

	@Override
	public List<CartDetail> listCartDetailByCartId(int cartId) {
		CriteriaBuilder builder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<CartDetail> criteria = builder.createQuery(CartDetail.class);
		Root<CartDetail> root = criteria.from(CartDetail.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("cartDetailId").get("cart"), cartId));
		List<CartDetail> list = hibernate.getSession().createQuery(criteria).getResultList();
		return list;
	}

	@Override
	public CartDetail getCartDetail(int cartId, int productId) {
		CriteriaBuilder builder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<CartDetail> criteria = builder.createQuery(CartDetail.class);
		Root<CartDetail> root = criteria.from(CartDetail.class);
		criteria.select(root);
		criteria.where(builder.and(builder.equal(root.get("cartDetailId").get("cart"), cartId),
				builder.equal(root.get("cartDetailId").get("product"), productId)));
		Query<CartDetail> query = hibernate.getSession().createQuery(criteria);
		List<CartDetail> list = query.getResultList();
		CartDetail productCart = list.size() != 0 ? list.get(0) : null;
		return productCart;
	}

	@Override
	public void deleteCartDetail(CartDetail cartDetail) {
		Cart cart = cartDetail.getCart();
		Date lastUpdateDate = hibernate.getSQLDate();
		cart.setLastUpdateDate(lastUpdateDate);
		cartDetail.setCart(cart);
		hibernate.getSession().delete(cartDetail);
		hibernate.getSession().merge(cart);
		hibernate.getSession().update(cart);
	}

	@Override
	public CartDetail getCartDetailByProductId(int productId) {
		CriteriaBuilder builder = hibernate.getSession().getCriteriaBuilder();
		CriteriaQuery<CartDetail> criteria = builder.createQuery(CartDetail.class);
		Root<CartDetail> root = criteria.from(CartDetail.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("cartDetailId").get("product"), productId));
		Query<CartDetail> query = hibernate.getSession().createQuery(criteria);
		List<CartDetail> list = query.getResultList();
		CartDetail productCart = (list.size() != 0) ? list.get(0) : null;
		return productCart;
	}

}
