package com.app.service;

import java.util.List;

import com.app.model.ExportReceipt;

public interface ProductExportRecService {

	void saveExportRecDetail(Long orderId, ExportReceipt exportReceipt);
	
	List<ExportReceipt> listProductExportRec(int productId);
	
}
