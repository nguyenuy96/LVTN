package com.app.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CHI_TIET_XUAT_KHO")
@AssociationOverrides({
		@AssociationOverride(name = "exportRecDetailId.exportReceipt", joinColumns = @JoinColumn(name = "MA_XUAT_KHO")),
		@AssociationOverride(name = "exportRecDetailId.product", joinColumns = @JoinColumn(name = "MA_SAN_PHAM")) })
public class ExportRecDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private ExportRecDetailId exportRecDetailId = new ExportRecDetailId();
	private Integer amount;

	@EmbeddedId
	public ExportRecDetailId getExportRecDetailId() {
		return exportRecDetailId;
	}

	public void setExportRecDetailId(ExportRecDetailId exportRecDetailId) {
		this.exportRecDetailId = exportRecDetailId;
	}

	@Transient
	public ExportReceipt getExportReceipt() {
		return getExportRecDetailId().getExportReceipt();
	}

	

	public void setExportReceipt(ExportReceipt exportReceipt) {
		getExportRecDetailId().setExportReceipt(exportReceipt);
	}

	@Transient
	public Product getProduct() {
		return getExportRecDetailId().getProduct();
	}

	public void setProduct(Product product) {
		getExportRecDetailId().setProduct(product);
	}

	@Column(name = "SO_LUONG")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
