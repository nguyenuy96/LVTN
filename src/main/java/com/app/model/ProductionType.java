package com.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "production_type")
public class ProductionType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productionTypeId;

	@Column(nullable = false, unique = true)
	private String productType;

	@JsonIgnore
	@OneToMany(mappedBy = "productionType")
	private Set<Production> production;

}
