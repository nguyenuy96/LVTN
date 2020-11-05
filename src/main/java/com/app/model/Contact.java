package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contact")
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String name;

	private String gender;

	private String phoneNumber;

	private String nationality;

	private String identification;

	private String address;

	private boolean isActive = true;

	@OneToOne
	private Account account;

	@OneToOne
	private Order order;
}
