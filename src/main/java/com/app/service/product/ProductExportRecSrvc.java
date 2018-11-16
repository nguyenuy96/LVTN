package com.app.service.product;

import java.util.List;

import com.app.model.ProductExportReceipt;

public interface ProductExportRecSrvc {

	void saveProductStorageRec();
	
	List<ProductExportReceipt> listProductExportRec(int productId);
}
