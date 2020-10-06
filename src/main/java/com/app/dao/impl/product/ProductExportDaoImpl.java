package com.app.dao.impl.product;

import java.sql.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.impl.HibernateResult;
import com.app.dao.ProductExportDao;
import com.app.model.ExportRecDetail;
import com.app.model.ExportReceipt;

@Repository
public class ProductExportDaoImpl implements ProductExportDao {

	@Autowired
	private HibernateResult hibernate;

	@Override
	public ExportReceipt saveExportRec(ExportReceipt exportReceipt) {
		Date exportDate = hibernate.getSQLDate();
		exportReceipt.setExportDate(exportDate);
		hibernate.getSession().save(exportReceipt);
		return exportReceipt;
	}

	@Override
	public List<ExportReceipt> listProductExportReceipt() {
		List<ExportReceipt> listProductExportReceipt = hibernate.getResultList(ExportReceipt.class);
		return listProductExportReceipt;
	}

	@Override
	public ExportReceipt getProductExportReceipt(int productExportReceiptId) {
		ExportReceipt productExportReceipt = hibernate.getById(ExportReceipt.class,
				productExportReceiptId);
		return productExportReceipt;
	}

	@Override
	public List<ExportReceipt> listProdExportByProduct(int productId) {
		Query<ExportReceipt> query = hibernate.inputIntQuery(ExportReceipt.class, "product", productId);
		List<ExportReceipt> listProdStorageRec = query.getResultList();
		return listProdStorageRec;
	}

	@Override
	public void saveExportRecDetail(ExportRecDetail exportRecDetail) {
		
		
		hibernate.getSession().save(exportRecDetail);
	}

}
