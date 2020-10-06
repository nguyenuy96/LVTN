package com.app.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ExportRecDetailId implements Serializable {
	private ExportReceipt exportReceipt;
	private Production production;

	@ManyToOne
	public ExportReceipt getExportReceipt() {
		return exportReceipt;
	}

	public void setExportReceipt(ExportReceipt exportReceipt) {
		this.exportReceipt = exportReceipt;
	}

	@ManyToOne
	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}
}
