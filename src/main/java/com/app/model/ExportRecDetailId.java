package com.app.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class ExportRecDetailId implements Serializable {
	@ManyToOne
	private ExportReceipt exportReceipt;
	@ManyToOne
	private Production production;
}
