package com.app.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ExportRecDetailId implements Serializable {
	private ExportReceipt exportReceipt;
	private Product product;

	@ManyToOne
	public ExportReceipt getExportReceipt() {
		return exportReceipt;
	}

	public void setExportReceipt(ExportReceipt exportReceipt) {
		this.exportReceipt = exportReceipt;
	}

	@ManyToOne
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
