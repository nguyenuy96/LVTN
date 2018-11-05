package com.app.dao.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.product.ProductExportDao;
import com.app.model.ProductExportReceipt;

@Repository
public class ProductExportDaoImpl implements ProductExportDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public void saveProductExport(ProductExportReceipt productExportReceipt) {
		String exportDate = hibernate.getMySQLDate();
		productExportReceipt.setExportDate(exportDate);
		hibernate.getSession().save(productExportReceipt);
	}

	@Override
	public List<ProductExportReceipt> listProductExportReceipt() {
		List<ProductExportReceipt> listProductExportReceipt = hibernate.getResultList(ProductExportReceipt.class);
		return listProductExportReceipt;
	}

	@Override
	public ProductExportReceipt getProductExportReceipt(int productExportReceiptId) {
		ProductExportReceipt productExportReceipt = hibernate.getById(ProductExportReceipt.class,
				productExportReceiptId);
		return productExportReceipt;
	}

}
