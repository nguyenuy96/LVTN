package com.app.model;

import lombok.Data;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "exporting_detail")
@AssociationOverrides({
        @AssociationOverride(name = "exportRecDetailId.exportReceipt", joinColumns = @JoinColumn(name = "exportingRecId")),
        @AssociationOverride(name = "exportRecDetailId.production", joinColumns = @JoinColumn(name = "productionId"))})
public class ExportRecDetail {
    @EmbeddedId
    private ExportRecDetailId exportRecDetailId = new ExportRecDetailId();
    @Transient
    private ExportReceipt exportReceipt = exportRecDetailId.getExportReceipt();
    @Transient
    private Production production = exportRecDetailId.getProduction();
    private Integer amount;
}
