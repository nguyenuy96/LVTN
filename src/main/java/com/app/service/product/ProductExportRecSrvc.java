package com.app.service.product;

import java.util.List;

import com.app.model.ExportReceipt;

public interface ProductExportRecSrvc {

	void saveExportRecDetail(int orderId, ExportReceipt exportReceipt);
	
	List<ExportReceipt> listProductExportRec(int productId);
	
}
