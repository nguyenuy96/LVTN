package com.app.dao.product;

import java.util.List;

import com.app.model.ProductExportReceipt;

public interface ProductExportDao {
	
	void saveProductExport(ProductExportReceipt productExportReceipt);

	List<ProductExportReceipt> listProductExportReceipt();

	ProductExportReceipt getProductExportReceipt(int productExportReceiptId);
}
