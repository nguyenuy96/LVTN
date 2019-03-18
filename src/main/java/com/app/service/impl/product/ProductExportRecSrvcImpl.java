package com.app.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.product.CartDao;
import com.app.dao.product.OrderDao;
import com.app.dao.product.ProductExportDao;
import com.app.model.CartDetail;
import com.app.model.ExportRecDetail;
import com.app.model.Order;
import com.app.model.ExportReceipt;
import com.app.service.product.ProductExportRecSrvc;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductExportRecSrvcImpl implements ProductExportRecSrvc{

	@Autowired
	private ProductExportDao productExportDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	@Override
	public void saveExportRecDetail(int orderId, ExportReceipt exportReceipt) {
		ExportReceipt expRec = productExportDao.saveExportRec(exportReceipt);
		Order order = orderDao.getOrder(orderId);
		int cartId = order.getCart().getCartId();
		List<CartDetail> list = cartDao.listCartDetailByCartId(cartId);
		for (CartDetail cartDetail: list) {
			ExportRecDetail exportRecDetail = new ExportRecDetail();
			exportRecDetail.setAmount(cartDetail.getAmount());
			exportRecDetail.setProduct(cartDetail.getProduct());
			exportRecDetail.getExportRecDetailId().setProduct(cartDetail.getProduct());
			exportRecDetail.getExportRecDetailId().setExportReceipt(expRec);
			productExportDao.saveExportRecDetail(exportRecDetail);	
		}
		order.setOrderState("Approved");
		orderDao.approveOrder(order);
	}

	@Override
	public List<ExportReceipt> listProductExportRec(int productId) {
		List<ExportReceipt> list = productExportDao.listProdExportByProduct(productId);
		return list;
	}

}
