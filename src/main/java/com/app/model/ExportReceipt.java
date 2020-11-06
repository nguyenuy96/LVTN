package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exporting")
public class ExportReceipt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exportingRecId;

	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;

	@OneToMany(mappedBy = "exportRecDetailId.exportReceipt", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ExportRecDetail> exportRecDetail = new HashSet<>();
}
