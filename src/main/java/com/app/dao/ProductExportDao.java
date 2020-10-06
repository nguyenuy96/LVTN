package com.app.dao;

import java.util.List;

import com.app.model.ExportRecDetail;
import com.app.model.ExportReceipt;

public interface ProductExportDao {
	
	ExportReceipt saveExportRec(ExportReceipt exportReceipt);

	List<ExportReceipt> listProductExportReceipt();

	ExportReceipt getProductExportReceipt(int productExportReceiptId);
	
	List<ExportReceipt> listProdExportByProduct(int productId);
	
	void saveExportRecDetail(ExportRecDetail exportRecDetail);
}
