package com.app.service.impl.product;

import java.util.List;

import com.app.dao.CartDetailDao;
import com.app.model.CartDetailId;
import com.app.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dao.ProductionDao;
import com.app.model.Cart;
import com.app.model.CartDetail;
import com.app.service.product.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductionDao productionDao;
	@Autowired
	private CartDetailDao cartDetailDao;

	@Override
	public Cart saveCart() {
		return cartDao.saveCart();
	}

	@Override
	public void addProductionIntoCart(CartDetail cartDetail) {
		Optionals.ifPresentOrElse(
				cartDetailDao.findById(cartDetail.getCartDetailId()),
				e -> {
					e.setAmount(cartDetail.getAmount());
					cartDao.updateCartDetail(e);
				},
				() -> cartDao.addCartDetail(cartDetail));
	}

	@Override
	public List<CartDetail> listCartDetailByCartId(Long cartId) {
		return cartDetailDao.findAllByIdCartId(cartId);
	}

	@Override
	public void deleteCartDetail(Long productId, Long cartId) {
		CartDetailId cartDetailId = new CartDetailId(new Cart(cartId), new Production(productId));
		Optionals.ifPresentOrElse(
				cartDetailDao.findById(cartDetailId),
				e -> cartDetailDao.delete(e),
				() -> {
					throw new IllegalArgumentException(String.format(
							"cart detail with cart id [%d] and production id [%d] not found", cartId, productId));
				});
	}

}
