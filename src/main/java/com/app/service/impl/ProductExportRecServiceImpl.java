package com.app.service.impl;

import java.util.List;

import com.app.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CartDetail;
import com.app.model.ExportRecDetail;
import com.app.model.Order;
import com.app.model.ExportReceipt;
import com.app.service.ProductExportRecService;

@Service
public class ProductExportRecServiceImpl implements ProductExportRecService {

	@Autowired
	private ProductExportDao productExportDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartDetailDao cartDetailDao;
	@Autowired
	private ExportRecDetailDao exportRecDetailDao;

	@Override
	public void saveExportRecDetail(Long orderId, ExportReceipt exportReceipt) {
		ExportReceipt expRec = productExportDao.save(exportReceipt);
		Order order = orderDao.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException(String.format("Order with id [%d] not found", orderId)));
		List<CartDetail> list = cartDetailDao.findAllByCartDetailIdCart(order.getCart().getCartId());
		for (CartDetail cartDetail: list) {
			ExportRecDetail exportRecDetail = new ExportRecDetail();
			exportRecDetail.setAmount(cartDetail.getAmount());
			exportRecDetail.setProduction(cartDetail.getProduct());
			exportRecDetail.getExportRecDetailId().setProduction(cartDetail.getProduct());
			exportRecDetail.getExportRecDetailId().setExportReceipt(expRec);
			exportRecDetailDao.save(exportRecDetail);
		}
		order.setOrderState("Approved");
		orderDao.save(order);
	}

	@Override
	public List<ExportReceipt> listProductExportRec(int productId) {
//		List<ExportReceipt> list = productExportDao.listProdExportByProduct(productId);
//		return list;
		return null;
	}

}
