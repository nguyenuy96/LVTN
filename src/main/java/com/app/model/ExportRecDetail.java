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
@Table(name = "exporting_detail")
@AssociationOverrides({
        @AssociationOverride(name = "exportRecDetailId.exportReceipt", joinColumns = @JoinColumn(name = "exportingRecId")),
        @AssociationOverride(name = "exportRecDetailId.product", joinColumns = @JoinColumn(name = "productionId"))})
public class ExportRecDetail implements Serializable {
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
    public Production getProduct() {
        return getExportRecDetailId().getProduction();
    }

    public void setProduct(Production production) {
        getExportRecDetailId().setProduction(production);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
