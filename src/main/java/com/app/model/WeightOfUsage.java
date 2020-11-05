package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weight")
public class WeightOfUsage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long weightId;

	private double startWeight;

	private double endWeight;

	private String size;
}
